package homework.day18;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 综合港台媒体消息，台湾地区领导人选举正在开票中。上一届台湾地区领导人选举投票率为80.28%，台选务主管机构预估，本届选情不若上届热络，保守估计约七成五。按此换算成选票约是1300万票，即只要任一方获得超过650万票过半门槛，就铁定当选。
 * *****  ******
 * 据中评社消息，下午6时左右，马萧得票破700万，胜谢苏200多万票。国民党主席吴伯雄、秘书长吴敦义已抵马萧总部。吴伯雄自行宣布当选。
 *
 *
 * 核心提示：第十二任台湾地区领导人选举今日举行，马萧(马英九、萧万长)竞选总部统计宣称已获得超过700万张选票，自行宣布当选。
 */
public class RandomAccessFileTest {
    public static void main(String[] args) {
        replaceContent(
                "src/homework/day18/a.txt",
                "*****  ******",
                "核心提示：第十二任台湾地区领导人选举今日举行，" +
                        "马萧(马英九、萧万长)竞选总部统计宣称已获得超过700万张选票，自行宣布当选。\n");
    }

    public static int replaceContent(String fileName, String sourceContent, String targetContent){
        StringBuilder builder = new StringBuilder();
        long index = -1;
        try(RandomAccessFile raf = new RandomAccessFile(
                fileName, "rw"
        )) {
            String line = null;
            while ((line = raf.readLine()) != null){
                if (line.contains("*****  ******")){
                    index = raf.getFilePointer() - line.getBytes().length -1;
                    while ((line = raf.readLine()) != null){
                        builder.append(line + "\n");
                    }
                    raf.seek(index);
                    raf.write(targetContent.getBytes());
                    raf.write(builder.toString().getBytes("ISO-8859-1"));
                    builder.replace(0, builder.length(), "");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

//    public static int replaceContentWithGBK(String fileName, String sourceContent, String targetContent){
//        StringBuilder builder = new StringBuilder();
//        long index = -1;
//        try(RandomAccessFile raf = new RandomAccessFile(
//                fileName, "rw"
//        )) {
//            String line = null;
//            while ((line = raf.readLine()) != null){
//                System.out.println(new String(line.getBytes("ISO-8859-1")));//
//                if (line.contains("*****  ******")){
//                    index = raf.getFilePointer() - line.getBytes().length -1;
//                    while ((line = raf.readLine()) != null){
//                        builder.append(line + "\n");
//                    }
//                    raf.seek(index);
//                    raf.write(targetContent.getBytes());
//                    raf.write(builder.toString().getBytes("ISO-8859-1"));
//                }
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }
}
