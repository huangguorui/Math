package Array.p3_2_17;

//自定义排序，需要使用到compare接口
public class Student implements  Comparable<Student>{
    private String name;

    //学生成绩
    private int score;
    public  Student(String name,int score){
        this.name = name;
        this.score = score;
    }


    //覆盖方法
    @Override
    public boolean equals(Object student){
        if(this == student){
            return true;
        }
        //student不可为空
        if(student ==null){
            return false;
        }
        //
        if(this.getClass() != student.getClass()){
            return false;
        }
        Student another = (Student)student;
        //转小写
        //return this.name.toLowerCase().equals(another.name.toLowerCase());
        //转大写
        return this.name.toUpperCase().equals(another.name.toUpperCase());

    }

    @Override
    public int compareTo(Student another) {
//        if(this.score < another.score)
//            return -1;
//        else if(this.score == another.score)
//            return 0;
//        return 1;
//
        //升序 从小到大
//        return  this.score-another.score;

        //降序，从大到小
        return  another.score-this.score;


    }
    @Override
    public String toString(){
        return String.format("Student(name:%s,score:%d)",name,score);
    }

    public static void main(String[] args) {
        Array<Student> arr = new Array<>();
        arr.addLast(new Student("Alice", 100));
        arr.addLast(new Student("Bob", 66));
        arr.addLast(new Student("Charlie", 88));
        System.out.println(arr);

    }
}
