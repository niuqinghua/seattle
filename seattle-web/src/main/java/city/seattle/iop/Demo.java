package city.seattle.iop;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by niuqinghua on 2014/9/15.
 */
public class Demo {

    public static void main(String[] args) {

        Demo demo = new Demo();

        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("demo1");
        arrayList.add("demo2");

        demo.iterator(arrayList);

        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("demo1");
        linkedList.add("demo2");

        demo.iterator(linkedList);
    }

    public void iterator(List<String> list) {
        if(CollectionUtils.isNotEmpty(list)) {
            for(String str : list) {
                System.out.println(str);
            }
        }
    }

}
