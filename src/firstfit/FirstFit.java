package firstfit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/10/29.
 */
public class FirstFit {

    private final static int GET = 1;
    private final static int GIVE = 0;

    private Memory topMemory;
    private List<Progress> progressList;

    private int[] arrayNumber = {1, 2, 3, 2, 4, 3, 1, 5, 6, 7, 6};
    private int[] arraySign = {GET, GET, GET, GIVE, GET, GIVE, GIVE, GET, GET, GET, GIVE};
    private int[] arrayMemory = {130, 60, 100, 60, 200, 100, 130, 140, 60, 50, 60};


    public FirstFit() {
        initMemoryList();
        initProgressList();
//        progressWithMemoryFF();
        progressWithMemoryBF();
    }

    private void initMemoryList() {

        topMemory = new Memory();
        topMemory.setLength(0);
        topMemory.setPosition(-1);

        Memory memory = new Memory();
        memory.setLength(640);
        memory.setPosition(0);
        memory.setNextMemory(null);

        topMemory.setNextMemory(memory);

    }

    private void initProgressList() {
        progressList = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            Progress progress = new Progress();
            progress.setLength(arrayMemory[i]);
            progress.setPosition(0);
            progress.setProgressNumber(i);
            progress.setSign(arraySign[i]);
            progress.setNumber(arrayNumber[i]);
            progressList.add(progress);
        }

    }

    private void progressWithMemoryFF() {

        //先通过作业的状态判断是需要获得还是释放内存
        //这个progress用for循环得到
        for (int i = 0; i < progressList.size(); i++) {
            showUseMemory();

            Progress progress = progressList.get(i);

            if (progress.getSign() == GET) {
                //需要获得内存
                if (topMemory.getNextMemory() == null) {
                    System.out.println("无空闲内存");
                } else {
                    Memory tempMemory = topMemory;
                    while (tempMemory.getNextMemory() != null) {
                        Memory nextMemory = tempMemory.getNextMemory();
                        if (nextMemory.getLength() >= progress.getLength()) {
                            //修改空闲内存被分配后的大小
                            nextMemory.setLength(nextMemory.getLength() - progress.getLength());
                            //修改程序的起始地址
//                            progressList.get(i).setPosition(nextMemory.getPosition());
                            changeProgressPosition(i, nextMemory.getPosition());
                            //修改空间内存被分配后的空闲内存的起始地址
                            nextMemory.setPosition(nextMemory.getPosition() + progress.getLength());
                            //这里会把nextMemory的值修改，需要把修改后的值重新赋值
                            tempMemory.setNextMemory(nextMemory);
                            break;


                        } else {
                            tempMemory = nextMemory;
                        }
                    }

//                    topMemory=tempMemory;
                }

            } else if (progress.getSign() == GIVE) {
                //进行释放内存
                Memory memory = new Memory();
                memory.setPosition(progress.getPosition());
                memory.setLength(progress.getLength());
                memory.setNextMemory(null);
                if (topMemory.getNextMemory() == null) {
                    topMemory.setNextMemory(memory);
                } else {
                    Memory tempMemory = topMemory;
                    while (tempMemory.getNextMemory() != null) {
                        Memory nextMemory = tempMemory.getNextMemory();
                        if (nextMemory.getPosition() + nextMemory.getLength() == memory.getPosition()) {
                            nextMemory.setLength(nextMemory.getLength() + memory.getLength());
                            tempMemory.setNextMemory(nextMemory);
                            break;
                        }
                        if (memory.getPosition() + memory.getLength() == nextMemory.getPosition()) {
                            nextMemory.setPosition(memory.getPosition());
                            nextMemory.setLength(nextMemory.getLength() + memory.getLength());
                            tempMemory.setNextMemory(nextMemory);
                            break;
                        }
                        if (nextMemory.getPosition() > memory.getPosition()) {
                            tempMemory.setNextMemory(memory);
                            memory.setNextMemory(nextMemory);
                            break;
                        } else {
                            tempMemory = nextMemory;
                        }
                    }
                    //这个内存插入的内存链表的最后一个
                    if (tempMemory.getNextMemory()==null){
                        tempMemory.setNextMemory(memory);
                    }
//                    topMemory=tempMemory;
                }
            }


        }
        showUseMemory();
        System.out.println("程序执行结束");

    }

    private void progressWithMemoryBF() {
        for (int i = 0; i < progressList.size(); i++) {
            showUseMemory();
            Progress progress = progressList.get(i);
            if (progress.getSign() == GET) {
                if (topMemory.getNextMemory() == null) {
                    System.out.println("无空闲内存");
                } else {
                    Memory tempMemory = topMemory;
                    while (tempMemory.getNextMemory() != null) {
                        Memory nextMemory = tempMemory.getNextMemory();
                        if (nextMemory.getLength() >= progress.getLength()) {
                            //修改空闲内存被分配后的大小
                            nextMemory.setLength(nextMemory.getLength() - progress.getLength());
                            //修改程序的起始地址
//                            progressList.get(i).setPosition(nextMemory.getPosition());
                            changeProgressPosition(i, nextMemory.getPosition());
                            //修改空间内存被分配后的空闲内存的起始地址
                            //对于BF而言地址已经没意义了
                            nextMemory.setPosition(nextMemory.getPosition() + progress.getLength());
                            //这里进行判断，对修改后的空闲地址，从小进行排序
                            //由于分配了内存所以空闲内存会越来越小
                            if (nextMemory.getLength()<tempMemory.getLength()){
                                tempMemory.setNextMemory(nextMemory.getNextMemory());
                                //从头开始找位置插入这个nextMemory
                                insertMemory(nextMemory);
                                break;

                            }




                            //这里会把nextMemory的值修改，需要把修改后的值重新赋值
                            tempMemory.setNextMemory(nextMemory);
                            break;


                        } else {
                            tempMemory = nextMemory;
                        }
                    }
                }
            } else if (progress.getSign() == GIVE) {
                Memory memory = new Memory();
                memory.setPosition(progress.getPosition());
                memory.setLength(progress.getLength());
                memory.setNextMemory(null);
                if (topMemory.getNextMemory() == null) {
                    topMemory.setNextMemory(memory);
                } else {
                    Memory tempMemory = topMemory;
                    while (tempMemory.getNextMemory() != null) {
                        Memory nextMemory = tempMemory.getNextMemory();

                        //在这里遍历整个列表，然后选择空闲空间进行合并
                        Memory memory1=topMemory;
                        while (memory1.getNextMemory()!=null){
                            Memory memory2=memory1.getNextMemory();
                            if (memory2.getPosition() + memory2.getLength() == memory.getPosition()) {
                                memory2.setLength(memory2.getLength() + memory.getLength());

                                if(memory2.getLength()>memory2.getNextMemory().getLength()){
                                    memory1.setNextMemory(memory2.getNextMemory());
                                    //这里可以优化，并不需要从链表开始查找
                                    insertMemory(memory2);
                                }
                                break;
                            }
                            if (memory.getPosition() + memory.getLength() == memory2.getPosition()) {
                                memory2.setPosition(memory.getPosition());
                                memory2.setLength(memory2.getLength() + memory.getLength());
//                                if(memory2.getLength()>memory2.getNextMemory().getLength()){
//                                    memory1.setNextMemory(memory2.getNextMemory());
//                                    //这里可以优化，并不需要从链表开始查找
//                                    insertMemory(memory2);
//                                }
                                if (memory2.getNextMemory()!=null){
                                    if(memory2.getLength()>memory2.getNextMemory().getLength()){
                                        memory1.setNextMemory(memory2.getNextMemory());
                                        //这里可以优化，并不需要从链表开始查找
                                        insertMemory(memory2);
                                    }
                                }else {
                                    memory1.setNextMemory(null);
                                    insertMemory(memory2);
                                }
                                break;
                            }
                            memory1=memory2;
                        }

                        if (memory1.getNextMemory()!=null){
                            break;
                        }


                        if (nextMemory.getLength() > memory.getLength()) {
                            tempMemory.setNextMemory(memory);
                            memory.setNextMemory(nextMemory);
                            break;
                        } else {
                            tempMemory = nextMemory;
                        }
                    }
                    //这个内存插入的内存链表的最后一个
                    if (tempMemory.getNextMemory()==null){
                        tempMemory.setNextMemory(memory);
                    }
                }
            }
        }
        showUseMemory();
        System.out.println("程序执行结束");
    }

    private void showUseMemory() {
        System.out.println("----------------------------");
        if (topMemory.getNextMemory() == null) {
            System.out.println("无空闲内存");
        } else {
            Memory tempMemory = topMemory;
            while (tempMemory.getNextMemory() != null) {

                Memory nextMemory = tempMemory.getNextMemory();
                System.out.println("空闲内存的起始地址：" + nextMemory.getPosition());
                System.out.println("空闲内存的空间：" + nextMemory.getLength());
                tempMemory = nextMemory;
            }
        }
    }

    private void changeProgressPosition(int progressNum, int position) {

        for (Progress aProgressList : progressList) {
            if (aProgressList.getNumber() == progressList.get(progressNum).getNumber()) {
                aProgressList.setPosition(position);
            }
        }

    }

    private void insertMemory(Memory memory){
        if (topMemory.getNextMemory()==null){
            System.out.println("无空闲内存");
        }else {
            Memory tempMemory = topMemory;
            while (tempMemory.getNextMemory() != null) {
                Memory nextMemory = tempMemory.getNextMemory();
                if (nextMemory.getLength() > memory.getLength()) {
                    tempMemory.setNextMemory(memory);
                    memory.setNextMemory(nextMemory);
                    break;
                } else {
                    tempMemory = nextMemory;
                }
            }
            if (tempMemory.getNextMemory()==null){
                memory.setNextMemory(null);
                tempMemory.setNextMemory(memory);

            }
        }
    }

}

