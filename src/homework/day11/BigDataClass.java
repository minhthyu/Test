package homework.day11;

/**
 * 1.假定大数据课程分为四个阶段，定义枚举类BigDateClass，用L1，L2,L3,L4表示这4个阶段，对应4个依次递增的等级
 * 	1.初级工程师，学费:10000
 * 	2.高级工程师,学费：15000
 * 	3.架构师，学费：20000
 * 	4.CEO，学费：30000
 *
 * 	写Test类，键盘录入某个值模拟用户想要通过学习大数据课程达到什么样的等级。
 */
public enum  BigDataClass {
    L1("初级工程师"){
        @Override
        void info() {
            System.out.println(this.getName() + "，学费:10000");
        }
    }, L2("高级工程师"){
        @Override
        void info() {
            System.out.println(this.getName() + "，学费：15000");
        }
    }, L3("架构师"){
        @Override
        void info() {
            System.out.println(this.getName() + "，学费：20000");
        }
    }, L4("CEO"){
        @Override
        void info() {
            System.out.println(this.getName() + "，学费：30000");
        }
    };

    private String name;


    BigDataClass(String level){
        this.name = level;
    }

    abstract void info();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
