import java.io.*;
import java.util.*;
import java.lang.*;
import java.text.*;
import javax.swing.JOptionPane;
public class fcm
{
   public static void main (String args[]) throws IOException 
     {
String ss1,ss2,ss3;

      // Scanner kb = new Scanner(System.in);
 
       int r,l,cl,p,rr1,rr2,rr3,i,j,f=0,f1=0;
       double s,th,s1,n,min=0,c1=0,c2=0,c3=0,cv1=0,cv2=0,cv3=0,t1=0,t2=0,t3=0,th1=0.4,th2=0.7;
       rr1=4;rr2=3;rr3=3; // values
       r=990;cl=2;
             
          //System.out.print("Enter number of rows:r");
         //r = kb.nextInt();
        //System.out.print("Enter number of columns:cl");
        // cl = kb.nextInt(); 

       double [][] a = new double [1000][10]; double [] b= new  double [1000];String [][] num= new String [1000][10];
double [] c= new  double [1000];double [] d= new  double [1000];double [] prev= new  double [1000];double [] temp= new  double [1000];
       double [][] x = new double [1000][10];double [][] y = new double [1000][10];
       double [][] z = new double [1000][10];double [][] z1 = new double [1000][10];
       File file1 = new File("C:\\Users\\ANJALI\\Desktop\\main_project\\dataset.txt");
       BufferedReader bufRdr1  = new BufferedReader(new FileReader(file1));
 
    String line = null;
    int row = 0;
    int col = 0;
    //read each line of text file
    while((line = bufRdr1.readLine()) != null && row< r )
    {   
    StringTokenizer st1 = new StringTokenizer(line,",");
    while (st1.hasMoreTokens())
    {
        //get next token and store it in the array
        num[row][col] = st1.nextToken();
        col++;
    }
    col = 0;
    row++;
    }

for(row=0;row<r;row++)
{
for(col=0;col<cl;col++)
{
a[row][col]=Double.parseDouble(num[row][col]);
}
}

for(j=0;j<cl;j++)
{
f=0;f1=0;int flag=1;
while(flag>0)
{
    
if(f==0)
{
for(i=0;i<r;i++)
{
if(i<rr1)                         //initial memberships
b[i]=0.0101010101010101;
else if(i>=rr1 && i<(rr1+rr2))
{ p=rr1-i;
if(p<0)
    p=-(p);
    c[p]=0.0101010101010101;
}
else
{ p=(rr1+rr2)-i;
if(p<0)
    p=-(p);
    d[p]=0.0101010101010101;
}
} //i 

f++;
}//if
else                            // next
{
n=0;

for(i=0;i<rr1;i++)
{ 
    n=(a[i][j]-c1);
b[i]=1/((n/ (a[i][j]-c1)) + (n/(a[i][j]-c2)) +(n/(a[i][j]-c3)) );

}
for(i=0;i<rr1;i++)
{ 
    n=(a[i+rr1][j]-c2);
c[i]=1/((n/ (a[i+rr1][j]-c1)) + (n/(a[i+rr1][j]-c2)) +(n/(a[i+rr1][j]-c3)) );
 
}
for(i=0;i<rr1;i++)
{  n=(a[i+(rr1+rr2)][j]-c3);
d[i]=1/((n/ (a[i+rr1+rr2][j]-c1)) + (n/(a[i+rr1+rr2][j]-c2)) +(n/(a[i+rr1+rr2][j]-c3)) );
  
}//i


}//else

 // center vectors
s=0;s1=0;
for(i=0;i<rr1;i++)
{ 
s=s+((b[i]*b[i])*a[i][j]);           
s1=s1+(b[i]*b[i]);
}
c1=s/s1;
s=0;s1=0;
for(i=0;i<rr2;i++)
{ s=s+((c[i]*c[i])*a[i+rr1][j]);
s1=s1+(c[i]*c[i]);
}
c2=s/s1;
s=0;s1=0;
for(i=0;i<rr3;i++)
{ s=s+((d[i]*d[i])*a[i+(rr1+rr2)][j]);
s1=s1+(d[i]*d[i]);
}
c3=s/s1;
min=0;
n=0;

for(i=0;i<r;i++)            // minimization
{
if(i<rr1)
{
n=(a[i][j]-c1)*(a[i][j]-c1);n=n*(b[i]*b[i]);
min=min+n;
}
else if(i>=rr1 && i<(rr1+rr2))
{ p=rr1-i;if(p<0)p=-(p);
n=(a[i][j]-c2)*(a[i][j]-c2);n=n*(c[p]*c[p]);
min=min+n;
}
else
{  p=(rr1+rr2)-i;if(p<0)p=-(p);
n=(a[i][j]-c3)*(a[i][j]-c3);n=n*(d[p]*d[p]);
min=min+n;
}
}//i

if(f1==0)
{
for(i=0;i<r;i++)            // condition
{
if(i<rr1)
prev[i]=b[i];
else if(i>=rr1 && i<(rr1+rr2))
{ p=rr1-i;
if(p<0)
    p=-(p);
    prev[i]=c[p];
}
else
{ p=(rr1+rr2)-i;
if(p<0)
    p=-(p);
prev[i]=d[p];
}

}//i
f1++;
} //if

else
{

for(i=0;i<r;i++)            // condition
{
if(i<rr1)
temp[i]=b[i]-prev[i];
else if(i>=rr1 && i<(rr1+rr2))
{
     p=(rr1)-i;
if(p<0)
    p=-(p);
    temp[i]=c[p]-prev[i];
}

else{
     p=(rr1+rr2)-i;
if(p<0)
    p=-(p);
temp[i]=d[p];
}
}//i

int big=0;

for(i=1;i<r;i++)
{
    
if(temp[i]>temp[big])
big=i;
}//i
if(j==0)
    th=th1;
else
    th=th2;
if(temp[big]<th)       //************threshold
        
{flag=0; break; }

} //else
flag++;
} //while
if(j==0)
{
    cv1=c1;cv2=c2;cv3=c3;
}
else
{
    t1=c1;t2=c2;t3=c3;
}
}//j  end of 2 center vector and membership calculation

 for(i=0;i<r;i++)
{
x[i][0]=a[i][0]-cv1;
x[i][1]=a[i][0]-cv2;
x[i][2]=a[i][0]-cv3;
x[i][0]=a[i][1]-t1;
x[i][1]=a[i][1]-t2;
x[i][2]=a[i][1]-t3;
}//i
 double pp,big=0;s=0;s1=0;
 for(i=0;i<r;i++)
{
for(j=0;j<3;j++)
{
    big=(x[i][j]-(y[i][j]+1));
    if(big<0)
        big=-(big);
z[i][j]=big;
s=(1-x[i][j])*(1-x[i][j]);
s1=(1-y[i][j])*(1-y[i][j]);
pp=Math.sqrt(s+s1);pp=1-pp;
if(pp<0)
    pp=-(pp);
z1[i][j]=pp;
}//j
}//i
 int sm;


for(l=1;l<=3;l++)
{p=0;
for(i=0;i<r;i++)
{ sm=0;
for(j=0;j<3;j++)
{
if(z[i][j]<z[i][sm])
    sm=j;
}//j
if(sm==(l-1))
  p++;
}//i

}//l
 
 for(l=1;l<=3;l++)
{p=0;
for(i=0;i<r;i++)
{ sm=0;
for(j=0;j<3;j++)
{
if(z1[i][j]<z1[i][sm])
    sm=j;
}//j
if(sm==(l-1))
    p++;
   
}//i
if(l==1)
    rr1=p;
else if(l==2)
    rr2=p;
else 
    rr3=p;
}//l
 

ss1=Integer.toString(rr1);ss2=Integer.toString(rr2);ss3=Integer.toString(rr3);
 System.out.println(" ss1"+ss1); System.out.println(" ss2"+ss2); System.out.println(" ss3"+ss3);

 try
   {
   sub_fcm frame=new sub_fcm(ss1,ss2,ss3);
   frame.setSize(400,300);
   frame.setVisible(true);
   }
   catch(Exception e)
   {JOptionPane.showMessageDialog(null, e.getMessage());}
   
}// main()
}// class


























