package com.careem;

import java.util.Random;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class ThreadsDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {





        /* This is how you create a thread. You create a thread & assign it a task. Once the task is done JAVA will kill
        the thread. To run multiple tasks async way we can create multiple threads with tasks using for loop, but is
        it ideal ? */

        /*
        creating a thread in following code. The catch block will not work because Runnable doesn't return the exception.
         Although we can handle the exception in run method of runnable.
        */

        /*
        Thread t1 = new Thread(new MyOtherTask());
        try {
            t1.start();
        } catch (Exception e) {
            System.out.println("exception happened");
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
        */


        /* What if we have 1k tasks will we create 1k threads using for loop ? One java thread corresponds to
        one OS thread so if we have 4 core OS, only 4 threads will be active at any given time. Also creating a thread
        is expensive process. So rather creating 1k threads, we can have a thread pool of fixed size and assign them 1k
        tasks. Threads will pick up tasks, complete those tasks & pick up new tasks. Internally thread pool use blocking
        queue ( which is thread safe due to concurrent operations on it ) to store submitted tasks. */



        // creating a thread pool
        // ExecutorService service = Executors.newFixedThreadPool(10);
        // ExecutorService service = Executors.newCachedThreadPool();
        /* ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        service.schedule(new MyOtherTask(), 5, TimeUnit.SECONDS); */



        /* Note we have two methods submit & execute. Execute method simply starts the task & doesn't return anything.
        It only takes Runnable as its argument. Submit method returns a Future object to manage the task. We can
        cancel the task prematurely, with the cancel method or wait for the task to finish executing, with get.
        It takes both Callable & Runnable as argument. If you don't maintain a reference to future there is no
        difference between submit & execute.
        https://stackoverflow.com/questions/18730290/what-is-the-difference-between-executorservice-submit-and-executorservice-execut
        */


        // executing 1k tasks on the thread pool
        /*
        for (int i = 0; i < 1000; i++) {
            service.execute(new MyOtherTask());
            // OR
            service.submit(new MyTask());
        }
        */



        // Future is a placeholder for the value that will arrive in the future.


        // Future<Integer> future = service.submit(new MyTask(false));
        //  OR
        /*
        Future<Integer> future = service.submit(() -> {
            System.out.println("task started");
            try {
                Thread.sleep(3000);
                System.out.println("task ended");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 2;
        });

       try {
           Integer res = future.get(4, TimeUnit.SECONDS);
           System.out.println("result from task " + res);
       }  catch (ExecutionException | InterruptedException | TimeoutException e) {
           System.out.println("exception happened");
           e.printStackTrace();
       }
       */




       /*
        The main issue with future is it is blocking, its get method blocks the main thread. Also chaining is not possible
        for multiple futures. A better version is CompletableFuture which is used to perform possible async ( non-blocking )
        computation & trigger dependant computations which could also be asynchronous. Some other disadvantages are:
        No manual completion, Can not be chained, can not be combined, no exception handling

        To understand with an example lets say we have an order program. The whole flow have 5 tasks where each task is
        dependent on previous task. We will loop the orders and in loop body we will be submitting tasks & getting value.
        If implemented with Future each task will be blocking the main thread so unless order one is completed we can't
        process order 2 & so on. What we ideally want is independent flows where task are dependent on each other within
        flow but each flow is independent of other flow.


        CompletableFuture have two methods: runAsync() & supplyAsync(), runAsync takes Runnable object & supplyAsync
        takes Supplier object. We use runAsync when our task doesn't return anything, it returns CompletableFuture<void>. By default, CompletableFuture
        runs on thread pool known as Forkjoinpool, we can also provide our own executor thread pool.

       */




        /*
        // In below code we are still using get which is blocking. We should rather ruse callback which will happen after
        // some action is completed.

        ExecutorService executorService = Executors.newCachedThreadPool();

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(()->{
            delay(2000);
            System.out.println("I am in Runnable - "+ Thread.currentThread().getName());
        }, executorService);


        System.out.println("I am in Main - "+ Thread.currentThread().getName());

        voidCompletableFuture.get();
         */





        //Callbacks for CompletableFuture:

        //thenApply: It takes a Function<T,R> argument. We use it if we want to transform the response of completableFuture and
        //return the value. thenApplyAsync is used if you want to run the task on separate thread pool

        //thenAccept: It takes a Consumer<T> argument. It takes the response & doesn't return anything. thenAcceptAsync.

        //thenRun: It takes a Runnable as argument. It doesn't take response & is used only if we want to perform some
        //operation after tasks are completed. thenRunAsync.

       CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(new OrderFetch()).thenApply((orderNum) -> {
           System.out.println(orderNum);
           return new InventoryCheck(orderNum).apply(2);
       }).thenApply((isPresent) -> {
           System.out.println(isPresent);
           return new AcceptPayment(isPresent).get();
       });

        System.out.println(completableFuture.get());


        


        /*
        Supplier<Integer> orderFetch = () -> {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return ThreadLocalRandom.current().nextInt(6);
        };


        Function<Integer, Boolean> inventoryCheck = (orderNum) -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return orderNum % 2 == 0;
        };


        Consumer<Boolean> acceptPayment = (isPresent) -> {
            String paymentStatus = null;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            paymentStatus = isPresent ? "payment accepted" : "payment not accepted";
            System.out.println(paymentStatus);
        };

        CompletableFuture<Void> cf = CompletableFuture.supplyAsync(orderFetch).thenApply(inventoryCheck).thenAccept(acceptPayment);

        cf.get();
        */



        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hi my name is airas");
            return "Hello";
        }).thenCompose((res) -> {
            return CompletableFuture.completedFuture(res);
        });

        System.out.println("yo");
        System.out.println("yo");
        System.out.println("yo");
        String res = stringCompletableFuture.get();
        System.out.println(res);


       Future<String> feature = ThreadsDemo.calculateAsync();

       String result = feature.get();
       System.out.println(result);

    }

    static void delay(Integer ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static Future<String> calculateAsync() throws InterruptedException {

        System.out.println("helooooo");

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hi my name is airas");
            return "Hello";
        });

        return completableFuture;
    }

}


 /*
 Callable interface and Runnable interface are used to encapsulate tasks supposed to be executed by another thread. However,
 Runnable instances can be run by Thread class as well as ExecutorService but Callable instances can only be executed
 via ExecutorService.

 Callable: We use callable in threads when we want to return some value for task. It also returns checked exception. We
 can't use it with Thread class.

 Runnable: Runnable is also used with threads. The only difference is it doesn't return value & exception. To handle
 exception we can use try catch in run method
 https://stackoverflow.com/questions/141284/the-difference-between-the-runnable-and-callable-interfaces-in-java
 */



class MyOtherTask implements Runnable {

    private final boolean isException = false;

    @Override
    public void run() {
        System.out.println("task started");
        try {
            Thread.sleep(3000);
            System.out.println("task ended");
            if (isException) {
                throw new InterruptedException();
            }
            System.out.println("result is 2");
        } catch (InterruptedException e) {
            System.out.println("error in Runnable task");
            e.printStackTrace();
        }
    }
}


class MyTask implements Callable<Integer> {

    private final boolean isException;

    public MyTask(boolean isException) {
        this.isException = isException;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("task started");
        Thread.sleep(3000);
        System.out.println("task ended");
        if (isException) {
            throw new InterruptedException();
        }
        return 2;
    }
}


class OrderFetch implements Supplier<Integer> {

    private static final Random random = new Random();

    @Override
    public Integer get() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return random.nextInt(6);
    }
}


class InventoryCheck implements Function<Integer, Boolean> {

    private final Integer order;

    InventoryCheck(Integer order) {
        this.order = order;
    }

    @Override
    public Boolean apply(Integer num) {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return order % 2 == 0;

    }
}


class AcceptPayment implements Supplier<String> {

    private final Boolean inventoryPresent;

    AcceptPayment(Boolean inventoryPresent) {
        this.inventoryPresent = inventoryPresent;
    }

    @Override
    public String get() {

        try {
            Thread.sleep(2000);
            return inventoryPresent ? "payment accepted" : "payment not accepted";
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "error in place";
        }
    }
}