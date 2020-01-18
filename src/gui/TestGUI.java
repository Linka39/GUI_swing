package gui;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.*;


public class TestGUI {
    private static final String path = "E:\\frame.txt";
    public static Map<String ,Integer> getXY() {
        try{
            File file = new File(path);
            if(!file.exists()){
                file.createNewFile();
            }
            String read = "";
            List<String > xys = new ArrayList<>();
            FileInputStream input = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(input);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while((read = bufferedReader.readLine())!=null){
                xys.add(read);
            }
            if(xys.size()>0){
                String xy = xys.get(xys.size() -1);
                String[] strings=xy.split(",");
                Map<String,Integer> map = new HashMap<>();
                map.put("x",Integer.valueOf(strings[0]));
                map.put("y",Integer.valueOf(strings[1]));
                return map;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        JFrame f =new JFrame("窗口");
        Map<String,Integer> xyMap = getXY();
        if(xyMap != null){
            f.setLocation(xyMap.get("x"),xyMap.get("y"));
        }else{
            f.setLocation(200,200);
        }
        f.setSize(400,300);
        f.setLayout(null);
        JButton b = new JButton("swing窗口测试");
        b.setBounds(50,50,280,30);

        f.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        /*Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        int num = s.nextInt();
        System.out.println(line);
        System.out.printf("数字为:%-5d",num);*/

        new Thread(new Runnable() {
            @Override
            public void run() {
                try(InputStream is = System.in;){
                    while(true){
                        int i = is.read();
                        System.out.println("ascii码为"+i);
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                BufferedWriter bufferedWriter = null;
                try{
                    FileOutputStream out = new FileOutputStream("E:\\frame.txt");
                    OutputStreamWriter writer = new OutputStreamWriter(out);
                    bufferedWriter = new BufferedWriter(writer);
                }catch (IOException e){
                    e.printStackTrace();
                }
                while(true){
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
//                    System.out.println("x:"+f.getX()+"y:"+f.getY());
                    StringJoiner joiner = new StringJoiner(",");
                    joiner.add(f.getX()+"").add(f.getY()+"");
                    try{
                        if(bufferedWriter != null){
                            // windows中的换行符为\r\n
                            bufferedWriter.write(joiner.toString()+"\r\n");
                            // 清楚缓冲数据流
                            bufferedWriter.flush();
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        /*f.setSize(400,200);
        f.setLayout(null);
        JButton b = new JButton("swing窗口测试");
        b.setBounds(50,50,280,30);
        f.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);*/
    }
}
