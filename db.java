import java.util.*;


public class db {
    mks students[] = new mks[10];

    int top = 0;
    void add(mks obj) {
        this.students[this.top] = obj;
        this.top++;
    }


    mks[] bubble(mks arr[], int top) {
      
        for (int i = 0; i < top; i++) {
            for (int j = 0; j < top; j++) {
                if (arr[i].sum > arr[j].sum) {
                    mks t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
        return arr;
    }

    void printDB() {
        int rank = 1;
        mks[] student = bubble(this.students, this.top);
        for (int i = 0; i < this.top; i++) {
            System.out.println(rank + " " + student[i].name);
            rank++;
        }
    }
    class stu {
        String name;
        int roll;
        stu() {
            Scanner in = new Scanner(System.in);

            System.out.println("Name roll");
            String[] i = in.nextLine().split(" ");
            this.name = i[0];
            this.roll = Integer.parseInt((i[1]));
        }
    }
    class spd extends stu {
        int admno;
        spd() {
            super();
            Scanner in = new Scanner(System.in);
            System.out.println("Admission No");
            this.admno = in.nextInt();
        }
    }

    class mks extends spd {
        int toInt(String c) {
            return Integer.parseInt(c);
        }
        int sum = 0;
        int[] StringtoArray(String str) {
            String strs[] = str.split(" ");
            int arr[] = new int[strs.length];
            for (int i = 0; i < strs.length; i++) {
                arr[i] = toInt(strs[i]);
                this.sum += arr[i];
            }
            return arr;
        }
        int mks[] = new int[6];

        mks() {

            super();
            Scanner in = new Scanner(System.in);
            System.out.println("Marks");
            String marks = in.nextLine();
            this.mks = StringtoArray(marks);
            //System.out.println("Markss" + Arrays.toString(this.mks));
        }
    }
    



    public static void main(String args[]) {
	db DB = new db();
        Scanner in = new Scanner(System.in);
while(1==1){

	System.out.println("1.Add_Student 2.Print DB");
	int x = in.nextInt();
	if(x==1){
		try{
		DB.add(DB.new mks());}
		catch(Exception e){
		System.out.println("Failed to ADD");	
		continue;
}
			
}

	else	DB.printDB();

}
        
    }
}
