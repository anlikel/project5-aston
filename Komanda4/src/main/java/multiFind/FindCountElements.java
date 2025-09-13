package multiFind;
import utils.Util;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class FindCountElements<T> {
    private int countThread;
    private AtomicInteger countElement;

    private List<T> listElements;

    private T element;

    public FindCountElements(List<T> list, T element){
        this.listElements = list;
        this.countThread = Runtime.getRuntime().availableProcessors();
        this.element = element;
        this.countElement = new AtomicInteger(0);
    }

    public  void find() throws InterruptedException {
        int start = 0;
        int size = 0;
        if(listElements != null) {
             size = listElements.size();
        }

        if(size == 0){
            Util.writeMessage("Коллекция пуста");
            return;
        }

        int fin = size / countThread;
        if(size <= countThread) {
            fin = size;
            countThread = 1;
        }

        CountDownLatch latch = new CountDownLatch(countThread);
        for (int i = 0; i < countThread; i++) {
            int st = start;
            int fn ;
            if (countThread - 1 == i) {
                fn = size ;
            }
            else {
                fn = start + fin;
            }

            Thread thread = new Thread(()->{
                try {
                    forCaunt(st, fn);
                }finally {
                    latch.countDown();
                }
            });
            thread.start();

            start = fn;

        }
        latch.await();
        Util.writeMessage("Количество вхождения элемента в коллекцию - " + countElement);
    }

    private void forCaunt(int start, int fin){
        for(int i = start; i < fin; i++){
            if(listElements.get(i).equals(element)){
                    countElement.incrementAndGet();
            }
        }
    }
}
