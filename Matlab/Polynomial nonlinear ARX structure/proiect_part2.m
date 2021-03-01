clear all; close all;
load iddata-15
% salvam in variabile datele din fisiere, pentru o utilizare mai eficienta d.p.d.v a timpului
u_id=id.u;
u_val=val.u;
y_id=id.y;
y_val=val.y;
N=length(u_id);
N2=length(u_val);
na_nb=3; % declaram numarul de intrari si iesiri calculati la pasii precedenti
grad=3; % declaram gradul maxim al polinomului
t=1;
mse_min_pred_id=intmax;
mse_min_pred_val=intmax;
mse_min_sim_id=intmax;
mse_min_sim_val=intmax;
tic;
for m=1:grad  % testam fiecare grad
    for na=1:na_nb  % testam pt fiecare na
      for nb=1:na_nb  % si pt fiecare nb

% calculam intrarile si iesirile la pasii precedenti, atat pt datele de identificare, cat si pt validare
x=zeros(N,na+nb);
x_val=zeros(N,na+nb);
for i=1:N
    for k=1:na
        if ((i-k)>0)
           x(i,k)=-y_id(i-k);
           x_val(i,k)=-y_val(i-k);
        end
    end
end
for i=1:N
    for k=1:nb
        if ((i-k)>0)
           x(i,na+k)=u_id(i-k);
           x_val(i,na+k)=u_val(i-k);
        end
    end
end

% generam matricea de regresori pentru a aproxima iesirea de predictie
phi_id=generatePhi(x,m);
phi_val=generatePhi(x_val,m);

%calculam vectorul de parametri theta, rezolvand sistemul y=phi*theta
theta=phi_id\y_id;

%calculam iesirea de predictie aproximata, pt datele de id si val
ypred_id=phi_id*theta;
ypred_val=phi_val*theta;


x=zeros(length(u_id),na+nb);
x_val=zeros(length(u_val),na+nb);
ysim_id=zeros(1,length(na+nb));
ysim_val=zeros(1,length(na+nb));
%calculam iesirea de simulare 
for i=1:N
    for k=1:na
       if ((i-k)>0)        
           x(i,k)=-ysim_id(i-k);
           x_val(i,k)=-ysim_val(i-k);
        end
    end
    
    for k=1:nb
        if ((i-k)>0)
            x(i,na+k)=u_id(i-k);
            x_val(i,na+k)=u_val(i-k);
        end
    end               
                 
phisim_id=generatePhi(x(i,:),m);
phisim_val=generatePhi(x_val(i,:),m);
ysim_id(i)=phisim_id*theta;
ysim_val(i)=phisim_val*theta;
end

ysim_id=ysim_id';
ysim_val=ysim_val';
%retinem valorile lui m, na, nb pentru tabelul de la final
m_t(t)=m;
na_t(t)=na;
nb_t(t)=nb;
%calculam eroarea medie patratica pentru predictie, respectiv simulare
mse_pred_id(t)=1/N*sum((y_id-ypred_id).^2);
mse_pred_val(t)=1/N*sum((y_val-ypred_val).^2);
mse_sim_id(t)=1/N*sum((y_id-ysim_id).^2);
mse_sim_val(t)=1/N*sum((y_val-ysim_val).^2);

%salvam MSE minim corespunzator fiecarei iesiri si iesirea respectiva
if(mse_pred_val(t)<mse_min_pred_val)
    mse_min_pred_val=mse_pred_val(t);
    ypred_min_val=ypred_val;
end
if(mse_pred_id(t)<mse_min_pred_id)
    mse_min_pred_id=mse_pred_id(t);
    ypred_min_id=ypred_id;
end
if(mse_sim_val(t)<mse_min_sim_val)
    mse_min_sim_val=mse_sim_val(t);
    ysim_min_val=ysim_val;
end
if(mse_sim_id(t)<mse_min_sim_id)
    mse_min_sim_id=mse_sim_id(t);
    ysim_min_id=ysim_id;
end
t=t+1;
      end
    end
end
%reprezentarea grafica a fiecarei iesiri in functie de setul de date corespunzator
plot(y_val); hold on; plot(ypred_min_val); 
title('Iesirea de predictie aproximata pe datele de validare');
legend('y_val','ypred_val');
figure
plot(y_id); hold on; plot(ypred_min_id); 
title('Iesirea de predictie aproximata pe datele de identificare');
legend('y_id','ypred_id');
figure
plot(y_val); hold on; plot(ysim_min_val); 
title('Iesirea de simulare aproximata pe datele de validare');
legend('y_val','ysim_val');
figure
plot(y_id); hold on; plot(ysim_min_id); 
title('Iesirea de simulare aproximata pe datele de identificare');
legend('y_id','ysim_id');

m_t=m_t'; na_t=na_t'; nb_t=nb_t'; 
mse_pred_id=mse_pred_id';
mse_pred_val=mse_pred_val';
mse_sim_id=mse_sim_id';
mse_sim_val=mse_sim_val';
%creem un tabel cu erorile in functie de fiecare m, na, nb
T=table(m_t,na_t,nb_t,mse_pred_id,mse_pred_val,mse_sim_id,mse_sim_val);
format long

toc; 









