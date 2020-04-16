package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by qindingkang on 2019/4/8.
 */
public class Tree {
    private TreeNode root;

    public void createTree(List<String> values) throws Exception{
        Queue<TreeNode> queue=new LinkedList<>();
        if (values.isEmpty())
            throw new Exception("数据错误");
        if (root==null){
            //创建root
            root=new TreeNode(values.get(0));
        }
        TreeNode p=root;
        for (int i=1;i<values.size();i++){
            if (p==null&&!queue.isEmpty()){
                p=queue.poll();
                i--;
                continue;
            }
            assert p != null;
            if (p.getLeftNode()==null){
                p.setLeftNode(new TreeNode(values.get(i)));
                queue.offer(p.getLeftNode());
            }else if (p.getRightNode()==null){
                p.setRightNode(new TreeNode(values.get(i)));
                queue.offer(p.getRightNode());
            }else {
                if (!queue.isEmpty()){
                    p=queue.poll();
                    i--;
                }
            }
        }
        System.out.println("1");

    }
}
