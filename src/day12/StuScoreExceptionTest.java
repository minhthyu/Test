package day12;

class StuScoreException extends Exception {
    public StuScoreException() {
        super();
    }

    public StuScoreException(String message) {
        super(message);
    }
}

class Student {
    private int id;
    private String name;
    private float score;

    public Student(int id, String name, float score) throws StuScoreException {
        this.id = id;
        this.name = name;
        if (score > 100 || score < 0)
            throw new StuScoreException("学生成绩输入异常");
        else {
            this.score = score;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) throws StuScoreException {
        if (score > 100 || score < 0)
            throw new StuScoreException("学生成绩输入异常");
        else this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}

public class StuScoreExceptionTest {
    public static void main(String[] args) {
        Student stu = null;
        try {
            stu = new Student(1, "wy", 100);
            stu.setScore(-1);
            System.out.println(stu);
        } catch (StuScoreException e) {
//            e.printStackTrace();
            System.out.println(stu);
            System.out.println(e.getMessage());
        }
    }
}
