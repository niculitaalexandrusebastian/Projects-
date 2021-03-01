function out=generatePhi(x,m)
g=size(x,2);
x_exp = zeros(1,g);
%% generam o matrice care contine toate combinatiile de exponenti ale regresorilor
for k=1:m
    for i=1:m
        v=[k zeros(1,g-1)];
        for j=1:length(v)
                if (j>1)
                    v(j)=i;
                end
                if(sum(v)<=m)
                    [C,ia,ic] = unique(perms(v),'rows');
                    [x_exp,ia,ic]=unique([x_exp; C],'rows');
                   end
        end
        end
end

%% calculam matricea Phi, folosind matricea exponentilor si setul de iesiri si intrari intarziate
k=1;
for i=1:size(x_exp,1)
    x_prod=1;
    for j=1:size(x_exp,2)
        x_prod=x_prod.*x(:,j).^(x_exp(i,j));
    end
    phi(:,k)=x_prod;
    k=k+1;
end
out=phi;
end