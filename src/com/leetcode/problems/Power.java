class Power
  {
      public static void main(String args[])
      {
        int x=2;
        int n=-5;
        System.out.println(pow(x,n));
      }
      public static double pow(int x,int n)
      {
      double y=1.0;
      long nn=n;
      if(n<0)
        {
          nn=-1*nn;
        }
      while(nn>0)
        {
          if(nn%2==0)
          {
            x=x*x;
            nn=nn/2;
          }
          else
          {
            y=y*x;
            nn=nn-1;
          }
        }
        if(n<0)
        {
         y=(double)1.0/(double)y;
        }
       return y;
      }
   }
