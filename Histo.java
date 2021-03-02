public class histo {

    public static int HistogramArea(int[] arr) {

        int area = 0;
        int maiorArea = 0;

        int elemBefore = 0;
        
        if(arr.length == 1)
          return arr[0];
          
        for (int i = 0; i < arr.length; i++) {

            int elem = arr[i];

            if (i == 0) {
                area = elem;
                maiorArea = area;
            } else {
                /* 
                  if it's not the first elem, get the previous
                  to compare
                */
                elemBefore = arr[i - 1];
                
                /*
                    if the current elem is bigger, it means we can either use its area or sum *at least* 
                    the same amout as the previous elem
                */
                if (elem >= elemBefore) {
                    if (elem > area) {
                        area = elem;
                    } else {
                        area += elemBefore;
                    }
                } else {
                
                    /*
                       If it's smaller, check the area behind current elem to see if we have space
                       to expand the area by the amount of the current elem.
                       If we find a smaller element, break loop because otherwise we'd have to 'shorten'
                       the area.
                    */              
                  
                    area = 0;
                    for (int j = i ; j >= 0; j--) {
                        if (arr[j] >= elem) {
                            area += elem;
                        } else {
                            break;
                        }

                    }
                }

                if (area > maiorArea) {
                    maiorArea = area;
                }

            }

        }

        return maiorArea;
    }

    public static void main(String[] args) {
        // keep this function call here     
        //Scanner s = new Scanner(System.in);
        int[] ar = new int[]{6, 3, 1, 4, 12,4, 5};
        System.out.print(HistogramArea(ar));
    }

}
