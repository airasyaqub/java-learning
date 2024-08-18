package com.careem;

import java.util.function.Consumer;
import java.util.function.Function;


// Functional interface: An interface with only one abstract method
interface MyFuncInterface {
    void foo();
}

//class SayableImpl implements Sayable {
//
//    @Override
//    public boolean say() {
//        return true;
//    }
//}

public class MethodReference {


    public static void main(String[] args) {


        /* Lambda expression implementing Functional interface. */
        // MyFuncInterface myFuncInterface = () -> bar();

        // or

        /* MyFuncInterface myFuncInterface = () -> {
            bar();
        }; */

        // or

        /* Method reference, refer existing method as implementation of functional interface abstract method. */
        MyFuncInterface myFuncInterface = MethodReference::bar;


        myFuncInterface.foo();



        /* IN CASE OF NOT USING CURLY BRACKETS AROUND BODY OF LAMBDA EXPRESSION:*/

        /* In lambda if body is simple expression, a return will be prepended to expression. Below will give error because
        Consumer abstract method return type is void not string */

        // Consumer<String> lambda1 = s -> s;

        /* Will work because Function abstract method have return type so return will be prepended.*/

        // Function<String, String> lambda2 = s -> s;

        /* In lambda if body is method/constructor call, it depends on the method of functional interface our lambda is
        implementing. If that method has return type, lambda body will prepend return.
        If that method has no return type, lambda body will not prepend return. ) */

        // Consumer abstract method have no return type so no return will be prepended.
        Consumer<String> lambda1 = s -> s.toString();

        // Function abstract method have return type so return will be prepended.
        Function<String, String> lambda2 =  s -> s.toString();



        /* Method reference is basically a sugar syntax for lambda. If our lambda is calling an existing method inside
        its body, we can use method reference in place of that lambda. This existing method will be used inside lambda
        body. So basically MR will be translated to lambda. The way translation is done by compiler is

        // Function<String, String> lambda2 =  String::toString; ( take this example )

        1. Compiler wil desugar toString ( which is an instance method ) to lambda, s -> s.toString();
        the toString will go in lambda body, the param section will be cross-checked & matched with FI
        & "s" becomes the receiver & here the referred method toString is going to be called on receiver.

        This MR to lambda is complex so just to make it easy, where ever an existing method is being called inside lambda
        convert to MR, all translation will be done by compiler. Obviously the return type of MR & interface method should be matched !

        The Method reference method return type could be ignored if Functional interface
        abstract method is void. Java allows you to call a method and ignore the return value
        (a method invocation expression as a statement). Since we allow this at the invocation,
        we also allow this when adapting a method to a functional interface whose arguments are compatible but the
        functional interface is void-returning. */

        // Works because FI method return type is void, so consumer return type is ignored.
        Consumer<String>         lambda3 = MethodReference::consume;
        Function<String, String> lambda4 = MethodReference::consume;

    }


    public static boolean bar() {
        System.out.println("Hello, this is static method.");
        return true;
    }

    static String consume(String s) { return s;}

}