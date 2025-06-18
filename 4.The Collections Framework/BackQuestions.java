import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BackQuestions {
    public static void main(String args[]){

    }
    int chars(List<String> strings){
        int chars=0;
        for(String s:chars){
            chars+=s.length;
        }
        return chars;
    }
    void print(Collection c){
        for(Iterator<E> it =  c.iterator();it.hasNext();){
            System.out.printf("%s ",it.hasNext());
        }
        System.out.println();
    }
    <E> int frequency(Collection <E> c, E e){
        int f=0;
        for(Iterator<E> it = c.iterator();it..hasNext();){
            if(it.next().equals(e)){
                ++f;
            }
        }
        return f;
    }
    <E> getLast(List<E> list){
        E last = null;
        for(Iterator<E> it = list.iterator();it,hasNext();){
            last=it.next();
        }
        return last;
    }
    <E> getElementAt(List<E> list, int index){
        E element = null;
        int i=0;
        for(Iterator<E> it = list.iterator();it.hasNext()&&i++<=index;){
            element = it.next();
        }
        return element;
    }
    <E> Collection toCollection(E[] a){
        Collection <E> c = new ArrayList<>();
        for(E ae:a){
            c.add(ae);
        }
        return c;
    }
}
