function phi=phi_matrix(x1,x2,m,n)
k=0;
%cu ajutorul acestei functii, generam toate combinatiile de produse intre x1 si x2 dupa regula urmatoare:
% x1^a*x2^b, unde a+b<=m
for i=1:n^2
    k=4; % incepem de la coloana 4 deoarece am completat anterior primele 3 coloane pentru cazul m=1
    for j=2:m
        phi(i,k)=x1(i)^j;
        k=k+1;              
        phi(i,k)=x2(i)^j;
        k=k+1;
    end
    for b=1:floor(m/2)
        phi(i,k)=(x1(i)^b)*(x2(i)^b);
        k=k+1;
    end
    for z=2:m-1
        phi(i,k)=(x1(i)^z)*x2(i);
        k=k+1;
        phi(i,k)=x1(i)*(x2(i)^z);
        k=k+1;
    end
    
    for c=2:m
        for r=c+1:m
            if (c+r<=m)
                phi(i,k)=(x1(i)^c)*(x2(i)^r);
                k=k+1;
                phi(i,k)=(x1(i)^r)*(x2(i)^c);
                k=k+1;
            end
        end
    end
end


end
