import java.util.*;


public class db1 {
	static int toInt(String c) {
		    return Integer.parseInt(c);
		}
    mks students[] = new mks[2];
    int top = 0;
    void add(mks obj) {
        students[top] = obj;
	top++;
    }

    mks[] bubble(mks arr[],int top) {
        mks ele,ele2;
        for (int i = 0; i < top; i++) {
            ele = arr[i];
            for (int j = 0; j < top; j++) {
                ele2 = arr[j];
                if (ele.sum > ele2.sum) {
                    mks t = ele;
                    arr[i] = arr[j];
                    arr[j] = ele;
                }
            }
        }
        return arr;
    }

     void printDB() {
        int rank = 1;
        mks[] student = bubble(this.students,this.top);
        for (int i = 0; i < this.top; i++) {
            System.out.println(rank + " " + student[i].name);
	    rank++;
        }
    }
    class stu {
        String name;
        int roll;
        stu(String name, int roll) {
            this.name = name;
            this.roll = roll;
        }
    }
    class spd extends stu {
        int admno;
        spd(String name, int roll, int admno) {
            super(name, roll);
            this.admno = admno;
        }
    }

    class mks extends spd {
        int toInt(String c) {
            return Integer.parseInt(c);
        }
        int sum=0;
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

        mks(String name, int roll, int admno, String marks) {
            //println("Name Roll admno");

            super(name, roll, admno);
            this.mks = StringtoArray(marks);
            //System.out.println("Markss" + Arrays.toString(this.mks));
        }
    }

    public static void main(String args[]) {

        db1 DB = new db1();
while(true){
        Scanner in = new Scanner(System.in);

        mks stu = DB.new mks("Hiro", 12, 1222, "15 34 343 232 2323 23");//DB.new mks(i[0],toInt(i[1]),toInt(i[2]),i[3]);
        DB.add(stu);

DB.add(DB.new mks("Hiros", 12, 1222, "1521 34 343 232 2323 23"));
System.out.println(DB.students);
        DB.printDB();
    }
}
}
