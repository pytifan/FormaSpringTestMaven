package org.region.forms.osvoenie.calculations;

import org.apache.commons.math3.analysis.differentiation.*;
import org.region.forms.osvoenie.form.data.CalculationsData;
import org.region.forms.osvoenie.form.data.Forma;

public class EqnGenerator implements MultivariateDifferentiableVectorFunction{
    
    private Double Rho, g; // = 1020.0; = 9.81; /* Плотность воды и ускорение свободного падения*/
    private double Lt = 4000.0, ODt = 0.089, IDt = ODt - 2*0.0065; /* Длина, внешний и внутренний диаметр НКТ*/
    private double St = Math.PI * Math.pow(IDt, 2)/4.0, Vt = St * Lt; /* Внутренняя площадь и объем НКТ*/
    private double ODcas = 0.168, IDcas = ODcas - 2.0 * 0.01; /* Внешний и внутренний диаметр обсадной колоны*/
    private double Scas = Math.PI * Math.pow(IDcas, 2)/4.0, Vcas = Scas * Lt; /* Площадь сечения и объем ОК*/
    private double Sann = (Math.PI * (Math.pow(IDcas, 2) - Math.pow(ODt, 2))) / 4.0; /* Площадь затрубного пространства*/
    private double Vann = Sann * Lt, Vwell = Vann + Vt; /* Объем затрубного пространства и скважины*/
    
    private int dim = 100;
    private int varsNo,eqnsNo,eqcount;
    
    private int in,bot,out;
    private char inType,botType,outType;
    
    private DerivativeStructure[] Xn, Xv, Pg;
    private DerivativeStructure[] Eqns;
    private DerivativeStructure Pu,Pb,Pz;
    private double[] xn, xv, pg, pv, vw;
    private double[] vars;
    private double pu,pb,pz;
    
    private String messEqnGenerator;
   // StringBuffer buffer = new StringBuffer();          
    public EqnGenerator(int out, char outType, int bot, char botType, int in, char inType, double[] vw, double[] pv, double pz, Forma forma, CalculationsData calculationsdata){
        //System.out.println("Создание MyFucntion");
        //System.out.println("Объявление переменных: физические константы");
        //System.out.println("Rho="+Rho+", g="+g);
        //System.out.println("Lt="+Lt+", ODt="+ODt+", IDt="+IDt+", St="+St+", Vt="+Vt);
        //System.out.println("ODcas="+ODcas+", IDcas="+IDcas+", Scas="+Scas+", Vcas="+Vcas);
        //System.out.println("Sann="+Sann+", Vann="+Vann+", Vwell="+Vwell);
        this.in=in;this.bot=bot;this.out=out;
        this.inType=inType;this.botType=botType;this.outType=outType;
        this.vw=vw.clone();
        this.pv=pv.clone();                
        this.pz=pz;
        this.Rho=  calculationsdata.getRho();
        this.g=  calculationsdata.getG();
    }
        
    @Override
    public DerivativeStructure[] value(DerivativeStructure[] Vars){
        inverseVarGenerator(out,outType,in,inType,Vars);
        DerivativeStructure[] F = eqnGenerator(out,outType,bot,botType,in,inType, Rho);
        return F;
    }
    
    @Override
    public double[] value(double[] x){
        double[] f = new double[x.length];
        DerivativeStructure[] X0 = new DerivativeStructure[x.length];
        for(int i=0;i<x.length;i++){
            X0[i] = new DerivativeStructure(x.length, 1, i, x[i]);
        }
        DerivativeStructure[] F0 = value(X0);
        for(int i=0;i<x.length;i++){
            f[i] = F0[i].getValue();
        }
        return f;
    }
        
    public void inverseVarGenerator(int out, char outType, int in, char inType, DerivativeStructure[] Vars){
       // buffer.append("inverseVarGenerator start! ");
        Xn=new DerivativeStructure[in+1];
        Xv=new DerivativeStructure[in+1];
        Pg=new DerivativeStructure[in+1];
        varsNo=Vars.length;
        
        if (outType=='N'&&inType=='N'){
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // xv[i] | xn[i+1] xv[i+1] ... xn[k-1]         xv[k-1]     | xn[k]      Pu       Pb         | Pg[i]      ... Pg[k]         //
        // 0     | 1       2       ... 2(in-out-1)-1   2(in-out-1) | 2in-2out-1 2in-2out 2in-2out+1 | 2in-2out+2 ... 3(in-out)+2   //
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //varsNo=3*(in-out)+3;
            Xv[out]=Vars[0];
            for(int i=1;i<=(in-out-1);i++){
                Xn[i+out]=Vars[2*i-1];
                Xv[i+out]=Vars[2*i];
            }
            Xn[in]=Vars[2*in-2*out-1];
            Pu=Vars[2*in-2*out];
            Pb=Vars[2*in-2*out+1];
            for(int i=2*in-2*out+2;i<varsNo;i++){
                Pg[i-(2*in-3*out+2)]=Vars[i];
            }
        } else if (outType=='N'&&inType=='W') {
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // xv[i] | xn[i+1] xv[i+1] ... xn[k]         xv[k]     | Pu         Pb         | Pg[i]      ... Pg[k]           //
        // 0     | 1       2       ... 2(in-out)-1   2(in-out) | 2in-2out+1 2in-2out+2 | 2in-2out+3 ... 3(in-out+1)     //
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //varsNo=3*(in-out)+4;
            Xv[out]=Vars[0];
            for(int i=1;i<=(in-out);i++){
                Xn[i+out]=Vars[2*i-1];
                Xv[i+out]=Vars[2*i];
            }
            Pu=Vars[2*in-2*out+1];
            Pb=Vars[2*in-2*out+2];
            for(int i=2*in-2*out+3;i<varsNo;i++){
                Pg[i-(2*in-3*out+3)]=Vars[i];
            }
        } else if (outType=='W'&&inType=='N') {
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // xn[i+1] xv[i+1] ... xn[k-1]         xv[k-1]       | xn[k]      Pu         Pb       | Pg[i+1]    ... Pg[k]         //
        // 0       1       ... 2(in-out-2)     2(in-out-1)-1 | 2in-2out-2 2in-2out-1 2in-2out | 2in-2out+1 ... 3(in-out)     //
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //varsNo=3*(in-out)+1;
            for(int i=0;i<=(in-out-2);i++){
                Xn[i+out+1]=Vars[2*i];
                Xv[i+out+1]=Vars[2*i+1];
            }
            Xn[in]=Vars[2*in-2*out-2];
            Pu=Vars[2*in-2*out-1];
            Pb=Vars[2*in-2*out];
            for(int i=2*in-2*out+1;i<varsNo;i++){
                Pg[i-(2*in-3*out)]=Vars[i];
            }       
        } else if (outType=='W'&&inType=='W') {
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        // xn[i+1] xv[i+1] ... xn[k]         xv[k]       | Pu       Pb         | Pg[i+1]    ... Pg[k]         //
        // 0       1       ... 2(in-out-1)   2(in-out)-1 | 2in-2out 2in-2out+1 | 2in-2out+2 ... 3(in-out)+1   //
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
            //varsNo=3*(in-out)+2;
            for(int i=0;i<=(in-out-1);i++){
                Xn[i+out+1]=Vars[2*i];
                Xv[i+out+1]=Vars[2*i+1];
            }
            Pu=Vars[2*in-2*out];
            Pb=Vars[2*in-2*out+1];
            for(int i=2*in-2*out+2;i<varsNo;i++){
                Pg[i-(2*in-3*out+1)]=Vars[i];
            }
        } else {
            System.out.println("Неопределенная комбинация в varGenerator");
          //  buffer.append("Неопределенная комбинация в varGenerator");
        }
    }
    
    public DerivativeStructure[] eqnGenerator(int out, char outType, int bot, char botType, int in, char inType, double Rho){
        DerivativeStructure[] F;
       // buffer.append("eqnGenerator start! ");
        if (outType=='N'&&botType=='N'&&inType=='N'){
            eqnsNo=3*(in-out)+3;
            F = new DerivativeStructure[eqnsNo];
            eqcount=0;
            for(int l=out;l<=in;l++){
                if (l==out&&out!=bot){
                    F[eqcount++]=Pg[l].subtract(pz);
                    F[eqcount++]=(Pg[l+1].add((Xv[l].subtract(Xn[l+1])).multiply(Rho*g))).subtract(Pg[l]);
                    F[eqcount++]=((Xn[l+1].subtract(Xv[l])).multiply(Sann)).subtract(vw[l]);
                } else if (l==out&&out==bot&&bot!=in) {
                    F[eqcount++]=Pg[l].subtract(pz);
                    F[eqcount++]=(Pg[l+1].add((Xv[l].subtract(Xn[l+1])).multiply(Rho*g))).subtract(Pg[l]);
                    F[eqcount++]=((Xv[l].subtract(Xn[l+1])).multiply(St)).subtract(vw[l]);
                    F[eqcount++]=Pg[l].subtract(Pb);
                } else if (out<l&&l<bot) {
                    F[eqcount++]=(Pg[l+1].add((Xv[l].subtract(Xn[l+1])).multiply(Rho*g))).subtract(Pg[l]);
                    F[eqcount++]=((Xn[l+1].subtract(Xv[l])).multiply(Sann)).subtract(vw[l]);
                    F[eqcount++]=((Pg[l].multiply(Sann)).multiply(Xv[l].subtract(Xn[l]))).subtract(pv[l]);
                } else if (l==bot&&bot!=in&&bot!=out) {
                    F[eqcount++]=(Pg[l+1].add((Xv[l].subtract(Xn[l+1])).multiply(Rho*g))).subtract(Pg[l]);
                    F[eqcount++]=((Xv[l].subtract(Xn[l+1])).multiply(St)).subtract(vw[l]);
                    F[eqcount++]=(Pg[l].multiply(((Xn[l].subtract(Lt)).multiply(Sann)).add((Xv[l].subtract(Lt)).multiply(St)))).add(pv[l]);
                    F[eqcount++]=Pg[l].subtract(Pb);
                } else if (bot<l&&l<in) {
                    F[eqcount++]=(Pg[l+1].add((Xv[l].subtract(Xn[l+1])).multiply(Rho*g))).subtract(Pg[l]);
                    F[eqcount++]=((Xv[l].subtract(Xn[l+1])).multiply(St)).subtract(vw[l]);
                    F[eqcount++]=((Pg[l].multiply(St)).multiply(Xn[l].subtract(Xv[l]))).subtract(pv[l]);
                } else if (l==in&&in!=bot) {
                    F[eqcount++]=Pg[l].subtract(Pu);
                    F[eqcount++]=((Pg[l].multiply(St)).multiply(Xn[l])).subtract(pv[l]);
                } else if (l==in&&in==bot&&bot!=out) {
                    F[eqcount++]=Pg[l].subtract(Pu);
                    F[eqcount++]=(Pg[l].multiply(((Xn[l].subtract(Lt)).multiply(Sann)).subtract(St*Lt))).add(pv[l]);
                    F[eqcount++]=Pg[l].subtract(Pb);
                } else {
                    System.out.println("Неопределенная комбинация в eqnGenerator: outType==N, botType==N, inType==N");
             //       buffer.append("Неопределенная комбинация в eqnGenerator: outType==N, botType==N, inType==N");
                }
            }
        } else if (outType=='N'&&botType=='N'&&inType=='W') {
            eqnsNo=3*(in-out)+4;
            F = new DerivativeStructure[eqnsNo];
            eqcount=0;
            for(int l=out;l<=in;l++){
                if (l==out&&out!=bot){
                    F[eqcount++]=Pg[l].subtract(pz);
                    F[eqcount++]=(Pg[l+1].add((Xv[l].subtract(Xn[l+1])).multiply(Rho*g))).subtract(Pg[l]);
                    F[eqcount++]=((Xn[l+1].subtract(Xv[l])).multiply(Sann)).subtract(vw[l]);
                } else if (l==out&&out==bot&&bot!=in) {
                    F[eqcount++]=Pg[l].subtract(pz);
                    F[eqcount++]=(Pg[l+1].add((Xv[l].subtract(Xn[l+1])).multiply(Rho*g))).subtract(Pg[l]);
                    F[eqcount++]=((Xv[l].subtract(Xn[l+1])).multiply(St)).subtract(vw[l]);
                    F[eqcount++]=Pg[l].subtract(Pb);
                } else if (out<l&&l<bot) {
                    F[eqcount++]=(Pg[l+1].add((Xv[l].subtract(Xn[l+1])).multiply(Rho*g))).subtract(Pg[l]);
                    F[eqcount++]=((Xn[l+1].subtract(Xv[l])).multiply(Sann)).subtract(vw[l]);
                    F[eqcount++]=((Pg[l].multiply(Sann)).multiply(Xv[l].subtract(Xn[l]))).subtract(pv[l]);
                } else if (l==bot&&bot!=in&&bot!=out) {
                    F[eqcount++]=(Pg[l+1].add((Xv[l].subtract(Xn[l+1])).multiply(Rho*g))).subtract(Pg[l]);
                    F[eqcount++]=((Xv[l].subtract(Xn[l+1])).multiply(St)).subtract(vw[l]);
                    F[eqcount++]=(Pg[l].multiply(((Xn[l].subtract(Lt)).multiply(Sann)).add((Xv[l].subtract(Lt)).multiply(St)))).add(pv[l]);
                    F[eqcount++]=Pg[l].subtract(Pb);
                } else if (bot<l&&l<in) {
                    F[eqcount++]=(Pg[l+1].add((Xv[l].subtract(Xn[l+1])).multiply(Rho*g))).subtract(Pg[l]);
                    F[eqcount++]=((Xv[l].subtract(Xn[l+1])).multiply(St)).subtract(vw[l]);
                    F[eqcount++]=((Pg[l].multiply(St)).multiply(Xn[l].subtract(Xv[l]))).subtract(pv[l]);
                } else if (l==in&&in!=bot) {
                    F[eqcount++]=(Pg[l].subtract(Pu)).subtract(Xv[l].multiply(Rho*g));
                    F[eqcount++]=(Xv[l].multiply(St)).subtract(vw[l]);
                    F[eqcount++]=((Pg[l].multiply(St)).multiply(Xn[l].subtract(Xv[l]))).subtract(pv[l]);
                } else if (l==in&&in==bot&&bot!=out) {
                    F[eqcount++]=(Pg[l].subtract(Pu)).subtract(Xv[l].multiply(Rho*g));
                    F[eqcount++]=(Xv[l].multiply(St)).subtract(vw[l]);
                    F[eqcount++]=(Pg[l].multiply(((Xn[l].subtract(Lt)).multiply(Sann)).add((Xv[l].subtract(Lt)).multiply(St)))).add(pv[l]);
                    F[eqcount++]=Pg[l].subtract(Pb);
                } else {
                    System.out.println("Неопределенная комбинация в eqnGenerator: outType==N, botType==N, inType==W");
              //      buffer.append("Неопределенная комбинация в eqnGenerator: outType==N, botType==N, inType==W");
                }
            }
         } else if (outType=='N'&&botType=='W'&&inType=='N') {
            eqnsNo=3*(in-out)+3;
            F = new DerivativeStructure[eqnsNo];
            eqcount=0;
            for(int l=out;l<=in;l++){
                if (l==out&&out!=bot){
                    F[eqcount++]=Pg[l].subtract(pz);
                    F[eqcount++]=(Pg[l+1].add((Xv[l].subtract(Xn[l+1])).multiply(Rho*g))).subtract(Pg[l]);
                    F[eqcount++]=((Xn[l+1].subtract(Xv[l])).multiply(Sann)).subtract(vw[l]);
                } else if (l==out&&out==bot&&bot!=in) {
                    F[eqcount++]=Pg[l].subtract(pz);
                    F[eqcount++]=(Pg[l+1].add((Xv[l].subtract(Xn[l+1])).multiply(Rho*g))).subtract(Pg[l]);
                    F[eqcount++]=(((Xv[l].subtract(Lt)).multiply(Sann)).add((Xn[l+1].subtract(Lt)).multiply(St))).add(vw[l]);
                    F[eqcount++]=(Pg[l].subtract((Xv[l].subtract(Lt)).multiply(Rho*g))).subtract(Pb);
                } else if (out<l&&l<bot) {
                    F[eqcount++]=(Pg[l+1].add((Xv[l].subtract(Xn[l+1])).multiply(Rho*g))).subtract(Pg[l]);
                    F[eqcount++]=((Xn[l+1].subtract(Xv[l])).multiply(Sann)).subtract(vw[l]);
                    F[eqcount++]=((Pg[l].multiply(Sann)).multiply(Xv[l].subtract(Xn[l]))).subtract(pv[l]);
                } else if (l==bot&&bot!=in&&bot!=out) {
                    F[eqcount++]=(Pg[l+1].add((Xv[l].subtract(Xn[l+1])).multiply(Rho*g))).subtract(Pg[l]);
                    F[eqcount++]=(((Xv[l].subtract(Lt)).multiply(Sann)).add((Xn[l+1].subtract(Lt)).multiply(St))).add(vw[l]);
                    F[eqcount++]=((Pg[l].multiply(Sann)).multiply(Xv[l].subtract(Xn[l]))).subtract(pv[l]);
                    F[eqcount++]=(Pg[l].subtract((Xv[l].subtract(Lt)).multiply(Rho*g))).subtract(Pb);
                } else if (bot<l&&l<in) {
                    F[eqcount++]=(Pg[l+1].add((Xv[l].subtract(Xn[l+1])).multiply(Rho*g))).subtract(Pg[l]);
                    F[eqcount++]=((Xv[l].subtract(Xn[l+1])).multiply(St)).subtract(vw[l]);
                    F[eqcount++]=((Pg[l].multiply(St)).multiply(Xn[l].subtract(Xv[l]))).subtract(pv[l]);
                } else if (l==in&&in!=bot) {
                    F[eqcount++]=Pg[l].subtract(Pu);
                    F[eqcount++]=((Pg[l].multiply(St)).multiply(Xn[l])).subtract(pv[l]);
                } else if (l==in&&in==bot&&bot!=out) {
                    
                } else {
                    System.out.println("Неопределенная комбинация в eqnGenerator: outType==N, botType==W, inType==N");
              //      buffer.append("Неопределенная комбинация в eqnGenerator: outType==N, botType==W, inType==N");
                }
            }        
        } else if (outType=='N'&&botType=='W'&&inType=='W') {
            eqnsNo=3*(in-out)+4;
             F = new DerivativeStructure[eqnsNo];
            eqcount=0;
            for(int l=out;l<=in;l++){
                if (l==out&&out!=bot){
                    F[eqcount++]=Pg[l].subtract(pz);
                    F[eqcount++]=(Pg[l+1].add((Xv[l].subtract(Xn[l+1])).multiply(Rho*g))).subtract(Pg[l]);
                    F[eqcount++]=((Xn[l+1].subtract(Xv[l])).multiply(Sann)).subtract(vw[l]);
                } else if (l==out&&out==bot&&bot!=in) {
                    F[eqcount++]=Pg[l].subtract(pz);
                    F[eqcount++]=(Pg[l+1].add((Xv[l].subtract(Xn[l+1])).multiply(Rho*g))).subtract(Pg[l]);
                    F[eqcount++]=(((Xv[l].subtract(Lt)).multiply(Sann)).add((Xn[l+1].subtract(Lt)).multiply(St))).add(vw[l]);
                    F[eqcount++]=(Pg[l].subtract((Xv[l].subtract(Lt)).multiply(Rho*g))).subtract(Pb);
                } else if (out<l&&l<bot) {
                    F[eqcount++]=(Pg[l+1].add((Xv[l].subtract(Xn[l+1])).multiply(Rho*g))).subtract(Pg[l]);
                    F[eqcount++]=((Xn[l+1].subtract(Xv[l])).multiply(Sann)).subtract(vw[l]);
                    F[eqcount++]=((Pg[l].multiply(Sann)).multiply(Xv[l].subtract(Xn[l]))).subtract(pv[l]);
                } else if (l==bot&&bot!=in&&bot!=out) {
                    F[eqcount++]=(Pg[l+1].add((Xv[l].subtract(Xn[l+1])).multiply(Rho*g))).subtract(Pg[l]);
                    F[eqcount++]=(((Xv[l].subtract(Lt)).multiply(Sann)).add((Xn[l+1].subtract(Lt)).multiply(St))).add(vw[l]);
                    F[eqcount++]=((Pg[l].multiply(Sann)).multiply(Xv[l].subtract(Xn[l]))).subtract(pv[l]);
                    F[eqcount++]=(Pg[l].subtract((Xv[l].subtract(Lt)).multiply(Rho*g))).subtract(Pb);
                } else if (bot<l&&l<in) {
                    F[eqcount++]=(Pg[l+1].add((Xv[l].subtract(Xn[l+1])).multiply(Rho*g))).subtract(Pg[l]);
                    F[eqcount++]=((Xv[l].subtract(Xn[l+1])).multiply(St)).subtract(vw[l]);
                    F[eqcount++]=((Pg[l].multiply(St)).multiply(Xn[l].subtract(Xv[l]))).subtract(pv[l]);
                } else if (l==in&&in!=bot) {
                    F[eqcount++]=(Pg[l].subtract(Pu)).subtract(Xv[l].multiply(Rho*g));
                    F[eqcount++]=(Xv[l].multiply(St)).subtract(vw[l]);
                    F[eqcount++]=((Pg[l].multiply(St)).multiply(Xn[l].subtract(Xv[l]))).subtract(pv[l]);
                } else if (l==in&&in==bot&&bot!=out) {
                    F[eqcount++]=(Pg[l].subtract(Pu)).subtract(Xv[l].multiply(Rho*g));
                    F[eqcount++]=(((Xv[l].subtract(Lt)).multiply(Sann)).subtract(St*Lt)).add(vw[l]);
                    F[eqcount++]=((Pg[l].multiply(St)).multiply(Xn[l].subtract(Xv[l]))).subtract(pv[l]);
                    F[eqcount++]=(Pu.add(Rho*g*Lt)).subtract(Pb);
                } else {
                    System.out.println("Неопределенная комбинация в eqnGenerator: outType==N, botType==W, inType==W");
               //     buffer.append("Неопределенная комбинация в eqnGenerator: outType==N, botType==W, inType==W");
                }
            }            
        } else if (outType=='W'&&botType=='N'&&inType=='N') {
            eqnsNo=3*(in-out)+1;
            F = new DerivativeStructure[eqnsNo];
            eqcount=0;
            for(int l=out;l<=in;l++){
                if (l==out&&out!=bot){
                    F[eqcount++]=((Xn[l+1].multiply(Rho*g)).add(pz)).subtract(Pg[l+1]);
                } else if (l==out&&out==bot&&bot!=in) {
                    
                } else if (out<l&&l<bot) {
                    F[eqcount++]=(Pg[l+1].add((Xv[l].subtract(Xn[l+1])).multiply(Rho*g))).subtract(Pg[l]);
                    F[eqcount++]=((Xn[l+1].subtract(Xv[l])).multiply(Sann)).subtract(vw[l]);
                    F[eqcount++]=((Pg[l].multiply(Sann)).multiply(Xv[l].subtract(Xn[l]))).subtract(pv[l]);
                } else if (l==bot&&bot!=in&&bot!=out) {
                    F[eqcount++]=(Pg[l+1].add((Xv[l].subtract(Xn[l+1])).multiply(Rho*g))).subtract(Pg[l]);
                    F[eqcount++]=((Xv[l].subtract(Xn[l+1])).multiply(St)).subtract(vw[l]);
                    F[eqcount++]=(Pg[l].multiply(((Xn[l].subtract(Lt)).multiply(Sann)).add((Xv[l].subtract(Lt)).multiply(St)))).add(pv[l]);
                    F[eqcount++]=Pg[l].subtract(Pb);
                } else if (bot<l&&l<in) {
                    F[eqcount++]=(Pg[l+1].add((Xv[l].subtract(Xn[l+1])).multiply(Rho*g))).subtract(Pg[l]);
                    F[eqcount++]=((Xv[l].subtract(Xn[l+1])).multiply(St)).subtract(vw[l]);
                    F[eqcount++]=((Pg[l].multiply(St)).multiply(Xn[l].subtract(Xv[l]))).subtract(pv[l]);
                } else if (l==in&&in!=bot) {
                    F[eqcount++]=Pg[l].subtract(Pu);
                    F[eqcount++]=((Pg[l].multiply(St)).multiply(Xn[l])).subtract(pv[l]);
                } else if (l==in&&in==bot&&bot!=out) {
                    F[eqcount++]=Pg[l].subtract(Pu);
                    F[eqcount++]=(Pg[l].multiply(((Xn[l].subtract(Lt)).multiply(Sann)).subtract(St*Lt))).add(pv[l]);
                    F[eqcount++]=Pg[l].subtract(Pb);
                } else {
                    System.out.println("Неопределенная комбинация в eqnGenerator: outType==W, botType==N, inType==N");    
              //      buffer.append("Неопределенная комбинация в eqnGenerator: outType==W, botType==N, inType==N");
                }
            }    
        } else if (outType=='W'&&botType=='N'&&inType=='W') {
            eqnsNo=3*(in-out)+2;
            F = new DerivativeStructure[eqnsNo];
            eqcount=0;
            for(int l=out;l<=in;l++){
                if (l==out&&out!=bot){
                    F[eqcount++]=((Xn[l+1].multiply(Rho*g)).add(pz)).subtract(Pg[l+1]);
                } else if (l==out&&out==bot&&bot!=in) {
                    
                } else if (out<l&&l<bot) {
                    F[eqcount++]=(Pg[l+1].add((Xv[l].subtract(Xn[l+1])).multiply(Rho*g))).subtract(Pg[l]);
                    F[eqcount++]=((Xn[l+1].subtract(Xv[l])).multiply(Sann)).subtract(vw[l]);
                    F[eqcount++]=((Pg[l].multiply(Sann)).multiply(Xv[l].subtract(Xn[l]))).subtract(pv[l]);
                } else if (l==bot&&bot!=in&&bot!=out) {
                    F[eqcount++]=(Pg[l+1].add((Xv[l].subtract(Xn[l+1])).multiply(Rho*g))).subtract(Pg[l]);
                    F[eqcount++]=((Xv[l].subtract(Xn[l+1])).multiply(St)).subtract(vw[l]);
                    F[eqcount++]=(Pg[l].multiply(((Xn[l].subtract(Lt)).multiply(Sann)).add((Xv[l].subtract(Lt)).multiply(St)))).add(pv[l]);
                    F[eqcount++]=Pg[l].subtract(Pb);
                } else if (bot<l&&l<in) {
                    F[eqcount++]=(Pg[l+1].add((Xv[l].subtract(Xn[l+1])).multiply(Rho*g))).subtract(Pg[l]);
                    F[eqcount++]=((Xv[l].subtract(Xn[l+1])).multiply(St)).subtract(vw[l]);
                    F[eqcount++]=((Pg[l].multiply(St)).multiply(Xn[l].subtract(Xv[l]))).subtract(pv[l]);
                } else if (l==in&&in!=bot) {
                    F[eqcount++]=(Pg[l].subtract(Pu)).subtract(Xv[l].multiply(Rho*g));
                    F[eqcount++]=(Xv[l].multiply(St)).subtract(vw[l]);
                    F[eqcount++]=((Pg[l].multiply(St)).multiply(Xn[l].subtract(Xv[l]))).subtract(pv[l]);
                } else if (l==in&&in==bot&&bot!=out) {
                    F[eqcount++]=(Pg[l].subtract(Pu)).subtract(Xv[l].multiply(Rho*g));
                    F[eqcount++]=(Xv[l].multiply(St)).subtract(vw[l]);
                    F[eqcount++]=(Pg[l].multiply(((Xn[l].subtract(Lt)).multiply(Sann)).add((Xv[l].subtract(Lt)).multiply(St)))).add(pv[l]);
                    F[eqcount++]=Pg[l].subtract(Pb);
                } else {
                    System.out.println("Неопределенная комбинация в eqnGenerator: outType==W, botType==N, inType==W");
              //      buffer.append("Неопределенная комбинация в eqnGenerator: outType==W, botType==N, inType==W");
                }
            }        
        } else if (outType=='W'&&botType=='W'&&inType=='N') {
            eqnsNo=3*(in-out)+1;
            F = new DerivativeStructure[eqnsNo];
            eqcount=0;
            for(int l=out;l<=in;l++){
                if (l==out&&out!=bot){
                    F[eqcount++]=((Xn[l+1].multiply(Rho*g)).add(pz)).subtract(Pg[l+1]);
                } else if (l==out&&out==bot&&bot!=in) {
                    F[eqcount++]=((Xn[l+1].multiply(Rho*g)).add(pz)).subtract(Pg[l+1]);
                    F[eqcount++]=(Pb.subtract(pz)).subtract(Rho*g*Lt);
                } else if (out<l&&l<bot) {
                    F[eqcount++]=(Pg[l+1].add((Xv[l].subtract(Xn[l+1])).multiply(Rho*g))).subtract(Pg[l]);
                    F[eqcount++]=((Xn[l+1].subtract(Xv[l])).multiply(Sann)).subtract(vw[l]);
                    F[eqcount++]=((Pg[l].multiply(Sann)).multiply(Xv[l].subtract(Xn[l]))).subtract(pv[l]);
                } else if (l==bot&&bot!=in&&bot!=out) {
                    F[eqcount++]=(Pg[l+1].add((Xv[l].subtract(Xn[l+1])).multiply(Rho*g))).subtract(Pg[l]);
                    F[eqcount++]=(((Xv[l].subtract(Lt)).multiply(Sann)).add((Xn[l+1].subtract(Lt)).multiply(St))).add(vw[l]);
                    F[eqcount++]=((Pg[l].multiply(Sann)).multiply(Xv[l].subtract(Xn[l]))).subtract(pv[l]);
                    F[eqcount++]=(Pg[l].subtract((Xv[l].subtract(Lt)).multiply(Rho*g))).subtract(Pb);
                } else if (bot<l&&l<in) {
                    F[eqcount++]=(Pg[l+1].add((Xv[l].subtract(Xn[l+1])).multiply(Rho*g))).subtract(Pg[l]);
                    F[eqcount++]=((Xv[l].subtract(Xn[l+1])).multiply(St)).subtract(vw[l]);
                    F[eqcount++]=((Pg[l].multiply(St)).multiply(Xn[l].subtract(Xv[l]))).subtract(pv[l]);
                } else if (l==in&&in!=bot) {
                    F[eqcount++]=Pg[l].subtract(Pu);
                    F[eqcount++]=((Pg[l].multiply(St)).multiply(Xn[l])).subtract(pv[l]);
                } else if (l==in&&in==bot&&bot!=out) {
                    
                } else {
                    System.out.println("Неопределенная комбинация в eqnGenerator: outType==W, botType==W, inType==N");
             //       buffer.append("Неопределенная комбинация в eqnGenerator: outType==W, botType==W, inType==N");
                }
            }            
        } else if (outType=='W'&&botType=='W'&&inType=='W') {
            eqnsNo=3*(in-out)+2;
            F = new DerivativeStructure[eqnsNo];
            eqcount=0;
            for(int l=out;l<=in;l++){
                if (l==out&&out!=bot){
                    F[eqcount++]=((Xn[l+1].multiply(Rho*g)).add(pz)).subtract(Pg[l+1]);
                } else if (l==out&&out==bot&&bot!=in) {
                    F[eqcount++]=((Xn[l+1].multiply(Rho*g)).add(pz)).subtract(Pg[l+1]);
                    F[eqcount++]=(Pb.subtract(pz)).subtract(Rho*g*Lt);
                } else if (out<l&&l<bot) {
                    F[eqcount++]=(Pg[l+1].add((Xv[l].subtract(Xn[l+1])).multiply(Rho*g))).subtract(Pg[l]);
                    F[eqcount++]=((Xn[l+1].subtract(Xv[l])).multiply(Sann)).subtract(vw[l]);
                    F[eqcount++]=((Pg[l].multiply(Sann)).multiply(Xv[l].subtract(Xn[l]))).subtract(pv[l]);
                } else if (l==bot&&bot!=in&&bot!=out) {
                    F[eqcount++]=(Pg[l+1].add((Xv[l].subtract(Xn[l+1])).multiply(Rho*g))).subtract(Pg[l]);
                    F[eqcount++]=(((Xv[l].subtract(Lt)).multiply(Sann)).add((Xn[l+1].subtract(Lt)).multiply(St))).add(vw[l]);
                    F[eqcount++]=((Pg[l].multiply(Sann)).multiply(Xv[l].subtract(Xn[l]))).subtract(pv[l]);
                    F[eqcount++]=(Pg[l].subtract((Xv[l].subtract(Lt)).multiply(Rho*g))).subtract(Pb);
                } else if (bot<l&&l<in) {
                    F[eqcount++]=(Pg[l+1].add((Xv[l].subtract(Xn[l+1])).multiply(Rho*g))).subtract(Pg[l]);
                    F[eqcount++]=((Xv[l].subtract(Xn[l+1])).multiply(St)).subtract(vw[l]);
                    F[eqcount++]=((Pg[l].multiply(St)).multiply(Xn[l].subtract(Xv[l]))).subtract(pv[l]);
                 } else if (l==in&&in!=bot) {
                    F[eqcount++]=(Pg[l].subtract(Pu)).subtract(Xv[l].multiply(Rho*g));
                    F[eqcount++]=(Xv[l].multiply(St)).subtract(vw[l]);
                    F[eqcount++]=((Pg[l].multiply(St)).multiply(Xn[l].subtract(Xv[l]))).subtract(pv[l]);
                } else if (l==in&&in==bot&&bot!=out) {
                    F[eqcount++]=(Pg[l].subtract(Pu)).subtract(Xv[l].multiply(Rho*g));
                    F[eqcount++]=(((Xv[l].subtract(Lt)).multiply(-Sann)).add(St*Lt)).subtract(vw[l]);
                    F[eqcount++]=((Pg[l].multiply(St)).multiply(Xn[l].subtract(Xv[l]))).subtract(pv[l]);
                    F[eqcount++]=(Pb.subtract(Pu)).subtract(Rho*g*Lt);
                } else {
                    System.out.println("Неопределенная комбинация в eqnGenerator: outType==W, botType==W, inType==W");
           //         buffer.append("Неопределенная комбинация в eqnGenerator: outType==W, botType==W, inType==W");
                }
            }                
        } else {
            System.out.println("Неопределенная комбинация в eqnGenerator");
         //   buffer.append("Неопределенная комбинация в eqnGenerator");
            F=new DerivativeStructure[1];
        }
        return F;
    }
}