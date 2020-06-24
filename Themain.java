import java.util.*;

public class Themain {
    static void fifo(List<Progmm> list){
        Collections.sort(list,Comparator.comparing(s->s.arriv));
        for (Progmm p:list) {
                for(int i=0;i<p.duree;i++){    //p.duree= execution time of programmes
                    p.affiche();
                }
        }
        System.out.println();
    }
    static void sjf(List<Progmm>list){// non préemptives
        List<Progmm> listarrv=new ArrayList<>();// the list of programes that arrived
        int i=0; //i use this variable as time counter
        Collections.sort(list,Comparator.comparing(s->s.arriv));//the list of all programs ... sorted by time that they arrived
        int l =list.size();// i use this counter to know if i selected all programmes or not yet
        int h=0;//a counter off programmes
        while(l!=0||!listarrv.isEmpty()){

            while(l!=0 &&list.get(h).arriv<=i){
                listarrv.add(list.get(h));
                l--;//every time I add programmes to the List of arrived program
                h++;// i add 1 to programs that i selected
                if (h>list.size()){ h=list.size()-1;}// i had erreur exception hh So i added this instruction(if it works don't touche it)
            }
            Collections.sort(listarrv,Comparator.comparing(s->s.duree));// the programs that arrived I sort them by time of execution
            int j=0;
            if (!listarrv.isEmpty()) {
                for (j = 0; j < listarrv.get(0).duree; j++) {
                    listarrv.get(0).affiche();             // i print the programme
                }
                listarrv.remove(0); // i remove the programme i printed
            }

            if (j == 0) {
                i++;    // if i didnt print the programme that means only 1 time unite is executed
            } else i = i + j;        // if i did .. so time=time+time_of_programme i printed

        }
        System.out.println();

    }
    static  void srtf(List<Progmm> list){
        List<Progmm> listarrv=new ArrayList<>();// the list of programes that arrived
        int i=0; //i use this variable as time counter
        Collections.sort(list,Comparator.comparing(s->s.arriv));//the list of all programs ... sorted by time that they arrived
        int l =list.size();// i use this counter to know if i selected all programmes or not yet
        int h=0;//a counter off programmes
        while(l!=0||!listarrv.isEmpty()){
            while(l!=0&&list.get(h).arriv<=i){
                listarrv.add(list.get(h));l--;h++;
                if (h>list.size()){ h=list.size()-1;}// i had erreur exception hh So i added this instruction(if it works don't touche it)
            }
            Collections.sort(listarrv,Comparator.comparing(s->s.duree));// the programs that arrived I sort them by time of execution
            if(!listarrv.isEmpty()){
                listarrv.get(0).affiche();
                listarrv.get(0).duree--;
                if(listarrv.get(0).duree==0){
                    listarrv.remove(0);
                }
            }

            i++;

        }
        System.out.println();
    }
    static void proi(List<Progmm>list){
        List<Progmm> listarrv=new ArrayList<>();
        int i=0;int h=0;
        Collections.sort(list,Comparator.comparing(s->s.arriv));
        int l =list.size();
        while (l!=0||!listarrv.isEmpty()){
            while(l!=0&&list.get(h).arriv<=i){
                listarrv.add(list.get(h));l--;h++;
                if (h>list.size()){ h=list.size()-1;}// i had erreur exception hh So i added this instruction(if it works don't touche it)
            }
            Collections.sort(listarrv,Comparator.comparing(s->s.priority));
            if(!listarrv.isEmpty()){
                listarrv.get(0).affiche();
                listarrv.get(0).duree--;
                if(listarrv.get(0).duree==0){
                    listarrv.remove(0);
                }
            }

            i++;
        }
        System.out.println();
    }
    static void RR(List<Progmm> list,int q){
        Collections.sort(list,Comparator.comparing(s->s.arriv));
        List<Progmm> listarrv=new ArrayList<>();
        int l = list.size();int h=0;int i =0;int q1=q;Progmm p=new Progmm("",0,0);
        while(l!=0||!listarrv.isEmpty()){

            while(l!=0&&list.get(h).arriv<=i){
                listarrv.add(list.get(h));l--;h++;
                if (h>list.size()){ h=list.size()-1;}// i had erreur exception hh So i added this instruction(if it works don't touche it)
            }
            if (p.duree != 0) {
                listarrv.add(p);
            }
            while(q1!=0&&!listarrv.isEmpty()&&listarrv.get(0).duree!=0){
                listarrv.get(0).affiche();
                q1--;listarrv.get(0).duree--;
            }
            if(!listarrv.isEmpty()) {
                p = listarrv.get(0);
                listarrv.remove(0);

            }
            q1=q;
            i++;
        }
    }

    public static void main(String[] args) {

        System.out.println("how much programmes there is? ");
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        List<Progmm> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            System.out.println("information about progam "+i);
            System.out.println("name  , execution time , Date of arrival");
            list.add(new Progmm(sc.next(),sc.nextInt(),sc.nextInt()));
        }
        System.out.println("FIFO: ");
        fifo(list);
        System.out.println("SJF : ");
        sjf(list);//non préemptives
        System.out.println("SRTF");
        srtf(list);
        list.clear();
        System.out.println("how much programmes there is? for Priority-based policy");
        n=sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("information about progam "+i);
            System.out.println("name  , execution time , Date of arrival , priority");
            list.add(new Progmm(sc.next(),sc.nextInt(),sc.nextInt(),sc.nextInt()));
        }
        System.out.println("Priority-based policy");
        proi(list);
        System.out.println("For round robin insr how much programmes there is and the Q ");
        n=sc.nextInt();int q=sc.nextInt();list.clear();
        for(int i=0;i<n;i++){
            System.out.println("information about progam "+i);
            System.out.println("name  , execution time , Date of arrival");
            list.add(new Progmm(sc.next(),sc.nextInt(),sc.nextInt()));
        }
        RR(list,q);
        
    }

}
