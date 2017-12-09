package pagememory;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by lenovo on 2017/11/12.
 */
public class RequestPageMemory {

    private static int MEMORY_NUM=4;

    private int[] optionArray=new int[320];
    private int[] testArray=new int[320];

    public RequestPageMemory() {
        initOptionArray();
//        System.out.println("数组长度："+optionArray.length);
//        for (int i=0;i<optionArray.length;i++){
//            System.out.println(optionArray[i]);
//        }

//        for (int i=0;i<testArray.length;i++){
//
//            if (i%10==0){
//                System.out.print("\n"+testArray[i]+" ");
//            }else {
//                System.out.print(testArray[i]+" ");
//            }
//        }
//        System.out.print("\n");
//
//        for (int i=0;i<optionArray.length;i++){
//
//            if (i%10==0){
//                System.out.print("\n"+optionArray[i]+" ");
//            }else {
//                System.out.print(optionArray[i]+" ");
//            }
//        }
//        System.out.print("\n\n\n");

        OPT();
        FIFO();
        LRU();

    }

    /**
     * 初始化随机数组
     */
    private void initOptionArray(){

        Random random=new Random(10);
        int m=random.nextInt(320);//不包括
        testArray[0]=m;
        optionArray[0]=m/10;
//        System.out.println(m/10);

        //上面已经产生了一个指令次序所以这里只需要产生319次就可以了
        for (int i=0;i<319;i++){

            int j=i%4;

            switch (j){
                case 0:{
                    m=m+1;
                    if (m==320) m=0;
                    break;
                }
                case 1:{
                    if (m==0||m==1||m==2){//如果是这两个情况那么m-2就会溢出,如果m=2不随机，那么肯定会执行0，所以也要随机
                        m=random.nextInt(160);
                    }else {
                        m=random.nextInt(m-2);
                    }
                    break;
                }
                case 2:{
                    m=m+1;
                    if (m==320) m=0;
                    break;
                }
                case 3:{
                    if (m==319){
                        m=random.nextInt(160)+160;
                    }
                    m=random.nextInt(320-(m+1))+m+1;
                    break;
                }

            }
            testArray[i+1]=m;
            optionArray[i+1]=m/10;
        }
    }

    private void OPT(){

        double successfulTimes=0.0;
        double failTimes=0.0;

        List<Integer> cpuPageList=new ArrayList<>();


        for (int i=0;i<optionArray.length;i++){

//            if (i%5==0){
//                System.out.print("\n");
//                showCupPageList(cpuPageList);
//            }else {
//                showCupPageList(cpuPageList);
//            }

            //内存块还有空闲的时候，直接添加
            if (cpuPageList.size()<MEMORY_NUM){
                failTimes++;
                if (isInCupPage(cpuPageList,optionArray[i])){
                    cpuPageList.add(optionArray[i]);
                }
            }else {
                //产生缺页中断
                if (isInCupPage(cpuPageList,optionArray[i])){
                    failTimes++;
                    List<Integer> tempList = new ArrayList<>();
                    tempList.addAll(cpuPageList);//作为一个临时栈，用来移除已经匹配到的page
                    for (int j=i+1;j<optionArray.length;j++){
                        for (Integer aCpuPageList : tempList) {

                            if (aCpuPageList == optionArray[j]&&tempList.size()>1) {
                                tempList.remove(aCpuPageList);
                                break;
                            }
                        }

                        //这里是当这个cpuList里面还剩最后一个page了那么肯定是最久才能使用
                        if (tempList.size()==1){
                            break;
                        }
                    }

                    //然后通过这两个for循环后的tempList就是可以删除的cpu中的page
                    cpuPageList.removeAll(tempList);

                    //然后添加上新的page
                    cpuPageList.add(optionArray[i]);

                }else {
                    successfulTimes++;
                }
            }
        }
//        showCupPageList(cpuPageList);
        System.out.println("OPT缺页率 = "+(failTimes/(successfulTimes+failTimes)));
    }


    private void FIFO(){

        double successfulTimes=0.0;
        double failTimes=0.0;

        List<Integer> cpuPageList=new ArrayList<>();
        for (int i=0;i<optionArray.length;i++) {

//            if (i%5==0){
//                System.out.print("\n");
//                showCupPageList(cpuPageList);
//            }else {
//                showCupPageList(cpuPageList);
//            }
            if (cpuPageList.size() < MEMORY_NUM) {
                failTimes++;
                if (isInCupPage(cpuPageList, optionArray[i])) {
                    cpuPageList.add(optionArray[i]);
                }
            } else {
                if (isInCupPage(cpuPageList, optionArray[i])) {
                    //通过FIFO算法删除再cpu中的页面，添加新的页面
                    //因为这是一个按顺序放入的，最先放数字为1
                    failTimes++;
                    cpuPageList.remove(0);
                    cpuPageList.add(optionArray[i]);
                } else {
                    successfulTimes++;
                }
            }
        }
//        showCupPageList(cpuPageList);
        System.out.println("FIFO缺页率 = "+(failTimes/(successfulTimes+failTimes)));


    }

    private void LRU(){

        double successfulTimes=0.0;
        double failTimes=0.0;
        List<Integer> cpuPageList=new ArrayList<>();
        for (int i=0;i<optionArray.length;i++) {

//            if (i%5==0){
//                System.out.print("\n");
//                showCupPageList(cpuPageList);
//            }else {
//                showCupPageList(cpuPageList);
//            }
////            System.out.print("插入的页 = " + anOptionArray);
//            showCupPageList(cpuPageList);
            if (cpuPageList.size() < MEMORY_NUM) {
                failTimes++;
                if (isInCupPage(cpuPageList, optionArray[i])) {
                    cpuPageList.add(optionArray[i]);
                }
            } else {
                if (isInCupPage(cpuPageList, optionArray[i])) {
                    //通过LRU算法将最近最久未使用的页面删除
                    failTimes++;
                    cpuPageList.remove(0);
                    cpuPageList.add(optionArray[i]);

                } else {//如果没有产生却页那么需要对cpu栈中的页面进行从新排序
                    successfulTimes++;
                    cpuPageList.remove((Integer) optionArray[i]);
                    cpuPageList.add(optionArray[i]);
                }
            }
        }
//        showCupPageList(cpuPageList);
        System.out.println("LRU缺页率 = "+(failTimes/(successfulTimes+failTimes)));


    }


    /**
     * 判断是否会产生缺页
     * @param cpuPageList cpu中已经存在的页面
     * @param optionPage 需要加入cpu中的页面
     * @return 是否产生缺页
     */
    private boolean isInCupPage(List<Integer> cpuPageList,int optionPage){

        for (int cupPage :cpuPageList){
            if (cupPage==optionPage){
                return false;
            }
        }

        return true;

    }


    private void showCupPageList(List<Integer> cpuPageList){


        for (Integer cpuPage : cpuPageList){
            System.out.print(cpuPage+"  ");
        }

        System.out.print("  |  ");


    }




}
