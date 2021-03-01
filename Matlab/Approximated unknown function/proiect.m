data=load('proj_fit_36.mat');
close all;
x1_id=data.id.X{1,1};
x2_id=data.id.X{2,1};       % salvam in variabile datele din fisiere, pentru o utilizare mai eficienta d.p.d.v a timpului
x1_val=data.val.X{1,1};
x2_val=data.val.X{2,1};
y_id=data.id.Y;
y_val=data.val.Y;
n=length(x1_id);
n2=length(x1_val);
m=35;  %declaram numarul de regresori (gradul aproximatorului) cu care vrem sa lucram
mse=0;
mse_id=0;
mse_star=intmax;
mse_star_id=intmax;
yhatstar=0;
for i=1:m   
    phi_id=0;
    phi_val=0;
    yhat_val=0;
    yhat=0;
    theta=0;
%% construim matricea de regresori de gradul 1 pt datele de identificare
% folosind functia reshape, in variabilele c1 si c2 pastram toate combinatiile liniare intre x1 si x2
c1=reshape(ones(n,n).*x2_id',n^2,1);
c2=reshape(x1_id.*ones(n,n),n^2,1);
phi_id=[ones(n^2,1) c1 c2];

%% analog pentru datele de validare
c1=reshape(ones(n2,n2).*x2_val',n2^2,1);
c2=reshape(x1_val.*ones(n2,n2),n2^2,1);
phi_val=[ones(n2^2,1) c1 c2];

phi2_id=phi_id(:,2);
phi3_id=phi_id(:,3);
% construim matricea de regresori cu datele de identificare pentru gradul curent i
if(i>1) phi_id=phi_matrix(phi2_id,phi3_id,i,n);
end

phi2_val=phi_val(:,2);
phi3_val=phi_val(:,3);
% analog pentru datele de validare
if (i>1) phi_val=phi_matrix(phi2_val,phi3_val,i,n2);
end
% transformam matricea de iesire intr-un vector coloana, pentru a putea rezolva sistemul liniar Y=phi*theta 
yhat=reshape(y_id,n^2,1);
% obtinem solutia sistemului (vectorul de parametri)
theta=phi_id\yhat;
% calculam iesirea estimata pentru ambele seturi de date
yhat_id=phi_id*theta;
yhat_val=phi_val*theta;

yhat_val=yhat_val';
yhat_id=yhat_id';
N=length(yhat_val);
N2=length(yhat_id);
% calculam eroarea medie patratica pentru ambele seturi de date
mse(i)=1/N*sum((yhat_val-reshape(y_val,1,length(y_val)^2)).^2);
mse_id(i)=1/N2*sum((yhat_id-reshape(y_id,1,length(y_id)^2)).^2);
if(i>1)
    if(mse(i)<mse_star) 
        mse_star=mse(i);  % salvam in variabila mse_star eroarea medie patratica minima 
        mse_star_id=mse_id(i);
        yhatstar=yhat_val; % salvam in variabila yhatstar iesirea estimativa cand eroarea este minima
        degree=i; % pastram gradul pentru care eroarea este minima (m=8 in cazul nostru)
    end
    
end
end
% transformam iesirile estimate din vectori coloana in matrici patratice, pentru a putea utiliza functia mesh
yhatstar=reshape(yhatstar,n2,n2);
yhat_val=reshape(yhat_val,n2,n2);
% reprezentam grafic iesirea estimativa cu eroare minima, in functie de ambele seturi de date
mesh(x1_id,x2_id,y_id','edgecolor','b');
hold on
mesh(x1_val,x2_val,yhatstar','edgecolor','r'); title(['Rezultatul aproximatorului pentru gradul m=', num2str(degree)]);
legend('y identificare','y estimat');
figure
mesh(x1_val,x2_val,y_val','edgecolor','b');
hold on
mesh(x1_val,x2_val,yhatstar','edgecolor','r'); title(['Rezultatul aproximatorului pentru gradul m=', num2str(degree)]);
legend('y validare','y estimat');
figure

% reprezentam grafic iesirea estimativa pentru gradul m declarat la inceput
mesh(x1_id,x2_id,y_id','edgecolor','b');
hold on
mesh(x1_val,x2_val,yhat_val','edgecolor','r'); title(['Rezultatul aproximatorului pentru gradul m=', num2str(m)]);
legend('y identificare','y estimat');
figure
mesh(x1_val,x2_val,y_val','edgecolor','b');
hold on
mesh(x1_val,x2_val,yhat_val','edgecolor','r'); title(['Rezultatul aproximatorului pentru gradul m=', num2str(m)]);
legend('y validare','y estimat');

%reprezentam grafic evolutia erorilor medii patratice pentru ambele seturi de date
figure
plot(mse_id); hold on
plot(mse); legend('MSE identificare', 'MSE validare');







