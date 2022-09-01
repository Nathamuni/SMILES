import java.util.*;

class smile
{
    //Vivian 
    public static void main(String[] args) 
    {
        
        Scanner get = new Scanner(System.in);

        //HASHMAP CONTAINING THE ELEMENTS--VALENCY PAIR
        HashMap<Character,Integer> eleval = new HashMap<>();
        eleval.put('C',4);
        eleval.put('N',3);
        eleval.put('O',2);
        eleval.put('H',1);

        //HASHMAP CONTAINING THE BONDS--VALUE PAIR
        HashMap<Character,Integer> bonds = new HashMap<>();
        bonds.put('-', 1);
        bonds.put('=', 2);
        bonds.put('#', 3);

        //INPUT FROM USER FOR SMILES NOTATION
        StringBuilder sb = new StringBuilder();
        System.out.println("ENTER THE SMILES NOTATION");
        sb.append(get.nextLine());
        //COVERT THE INPUT INTO A CHARACTER ARRAY
        ArrayList<Character> res = new ArrayList<>();
        for(int i=0;i<sb.length();i++)
        {
            res.add(sb.charAt(i));
        }
        
        //CREATING A LIST WITHOUT ANY BONDS
        ArrayList<Character> res2 = new ArrayList<>();
        for(int i=0;i<res.size();i++)
        {
            if(res.get(i)=='-'||res.get(i)=='='||res.get(i)=='#') continue;
            else{
                res2.add(res.get(i));
            }
        }

        //ADJACENCY MATRIX
        //int[][] adjmat = new int[res2.size()][res2.size()];

        //CALCULATING THE ELEMENTS VALENCY
        int valency = 0;
        ArrayList<Integer> finval = new ArrayList<>();
        for(int i=0;i<res.size();i++)
        {
            if(res.get(i)=='-'||res.get(i)=='='||res.get(i)=='#') continue;
            else
            {
                if(i==0)
                {
                    valency = (int)(eleval.get(res.get(i)) - bonds.get(res.get(i+1)));
                    if(valency<0) System.out.println("Error");
                    finval.add(valency);
                }
                if(i==res.size()-1)
                {
                    valency = (int)(eleval.get(res.get(i)) - bonds.get(res.get(i-1)));
                    if(valency<0) System.out.println("Error");
                    finval.add(valency);
                }         
                if((i>=1)&&(i<res.size()-1))
                {
                    if((res.get(i)!='-')||(res.get(i)!='=')||(res.get(i)!='#'))
                    {
                        valency = (int)(eleval.get(res.get(i)) - (bonds.get(res.get(i-1))+bonds.get(res.get(i+1))));
                        if(valency<0) System.out.println("Error");
                        finval.add(valency);
                    }           
                }
            }
        }
        //ARRAYLIST CONTAINING ELEMENTS WITH BONDS
        System.out.println(res);
        //CONTAINS THE VALENCY OF ELEMENTS AFTER CALCULATION
        System.out.println(finval);
        //ARRAYLIST CONTAINING ELEMENTS WITHOUT BONDS
        System.out.println(res2);
    }
}


