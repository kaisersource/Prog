/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passparametri;



public class PassParametri {
       int a;
       
    public int passaggio (int x){
        x=30;
        return x;
 }
    public static void main(String[] args) {
        PassParametri p=new PassParametri();
        p.a=20;
        p.a=p.passaggio(p.a);
        System.out.println(p.a);
        
    }
    
}
