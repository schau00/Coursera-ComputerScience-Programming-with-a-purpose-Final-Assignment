import java.util.Arrays;
/**
 * BarChartRacer
 */
public class BarChartRacer {

    public static void main(String[] args) { 
        int x = 0;
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(1000, 700);
        
        
        StdAudio.loop("The-Avengers-Theme-Song (online-audio-converter.com).wav");
        In fn = new In(args[0]);
        int k = Integer.parseInt(args[1]);
        String title , xaxislabel , datasrc ;
        title = fn.readLine();
        xaxislabel = fn.readLine();
        datasrc = fn.readLine();
        BarChart chart = new BarChart(title, xaxislabel, datasrc);
        while(fn.isEmpty() == false){
            StdDraw.pause(2);
            //chart.reset();
            String space = fn.readLine();
            int n = Integer.parseInt(fn.readLine());
            Bar bar[] = new Bar [n];
            String label = "" ;
            for(int i=0;i<n;i++){
                String ln = fn.readLine();
                //StdOut.println(ln);
                String [] lnarray = ln.split(",");
                //StdOut.println(lnarray.length);
                String year,name,aCountry,category;
                int value ;
                year = lnarray[0];
                name = lnarray[1];
                aCountry = lnarray[2];
                value = Integer.parseInt(lnarray[3]);
                category = lnarray[4];

                bar[i] = new Bar(name, value, category);
                label = year;
            }
            int xmax = 1 ;
            Arrays.sort(bar);
            for(int i=n-1;i>n-k-1;i--){
                if(bar[i].barvalue <= 0){
                    break ;
                }
                chart.add(bar[i].barname, bar[i].barvalue, bar[i].barcat);
                xmax = Math.max(xmax,bar[i].barvalue);
            }
            chart.setCaption(label);
            chart.setMaxValue(xmax);
            StdDraw.pause(50);
            chart.draw();
            StdDraw.show();
            
            
            
            StdDraw.clear();
            x ++ ;
            chart.reset();
            



        }
        //StdOut.print(x);

    }
}