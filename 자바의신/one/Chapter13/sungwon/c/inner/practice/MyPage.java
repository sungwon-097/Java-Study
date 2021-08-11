package one.Chapter13.sungwon.c.inner.practice;

public class MyPage {
    InputBox input;
    public static void main(String[] args){
        MyPage mypage= new MyPage();
        mypage.setUI();
        mypage.pressKey();
    }
    public void setUI(){
        input=new InputBox();
        KeyEventListener listener=new KeyEventListener(){
            @Override
            public void onKeyDown(){
                System.out.println("Key Down");
            }
            @Override
            public void onKeyUp(){
                System.out.println("Key Up");
            }
        };
        input.setKeyListener(listener);
    }
    public void pressKey(){
        input.listenerCalled(InputBox.KEY_DOWN);
        input.listenerCalled(InputBox.KEY_UP);
    }
}