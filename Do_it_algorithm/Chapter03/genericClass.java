package Do_it_algorithm.Chapter03;

// 제네릭은 처리해야 할 대상의 자료형에 의존하지 않는 클래스 or 인터페이스 (c++에서는 TEPLATE)
class genericClass {
    static class GenericClass<T>{
        private T xyz;
        GenericClass(T t){
            this.xyz = t;
        }
        T getXyz(){return xyz;}
    }

    public static void main(String[] args) {
        GenericClass<String> s = new GenericClass<String>("ABC"); // parameter에 string, integer를 넘김
        GenericClass<Integer> n = new GenericClass<Integer>(15);

        System.out.println(s.getXyz());
        System.out.println(n.getXyz());
    }
}