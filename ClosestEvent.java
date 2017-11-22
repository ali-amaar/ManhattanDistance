import java.util.*;
public class ClosestEvent{

  public static void main(String args[]){
    int[] a = new int[]{1,2};
    int x = 0, y = 0;
    int kk = 0;
    int tempDistance = 0;
    int eventKey = 1;
    int ManhattanDistance = 0;
    int eventkey2 =0;
    int priceKey = 0;
    // taking input coordinates
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a coordinate: ");
    String coordinate = input.nextLine();
    String[] parts = coordinate.split(",");
    try {
      x = Integer.valueOf(parts[0]);
      y = Integer.valueOf(parts[1]);
    }
    catch(NumberFormatException e) {
      System.out.println("Input is not a valid integer");
      System.exit(1);
    }
    if(y > 10 || y < -10){
      throw new IllegalArgumentException("invalid y coordinate");
    }
    if(x > 10 || x < -10){
      throw new IllegalArgumentException("invalid x coordinate");
    }

    //generate seed data
    Map<Integer, int[]> eventsMap = new HashMap<Integer, int[]>();
    eventsMap = events();
    Map<Integer, double[]> eventDetails = new HashMap<Integer, double[]>();
    eventDetails = eventsDet();
    //initialise array for closest 5 events
    ArrayList<Integer> fiveEvents = new ArrayList<Integer>();

    System.out.printf("closest events to (%d,%d)\n\n",x,y);
    /* Looping through the map of 10 events and will check for locations
     * around the radius of the chosen coordinates. radius will keep
     * incrementing by 1 until 5 events are found
     */
    while(fiveEvents.size() < 5 && eventKey <= eventsMap.size()){
      for(kk = 0; kk < 10; kk++){
        if(fiveEvents.size() == 5){
          break;
        }
        int[] values = eventsMap.get(eventKey);
        ManhattanDistance = (Math.abs(x-values[0]) + Math.abs(y-values[1]));
        if(ManhattanDistance == tempDistance){
          fiveEvents.add(eventKey);
        }
        eventKey++;
      }
      eventKey = 1;
      tempDistance++;
    }
    while(eventkey2 < fiveEvents.size()){
      priceKey = fiveEvents.get(eventkey2);
      double[] prices = eventDetails.get(priceKey);
      int[] values2 = eventsMap.get(priceKey);
      ManhattanDistance = (Math.abs(x-values2[0]) + Math.abs(y-values2[1]));
      //sort array is ascending order to obtain cheapest price
      Arrays.sort(prices);
      System.out.printf("event %03d - $%2.2f, Distance %d\n", priceKey, prices[0],ManhattanDistance);
      eventkey2++;
    }
  }
  //generating seed data
  private static Map<Integer, int[]> events(){
    Map<Integer, int[]> eventsMap = new HashMap<Integer, int[]>();
    /* event 1 */
    int[] e1 = {-8,-6};
    eventsMap.put(1,e1);
    /* event 2 */
    int[] e2 = {4,1};
    eventsMap.put(2,e2);
    /* event 3 */
    int[] e3 = {9,2};
    eventsMap.put(3,e3);
    /* event 4 */
    int[] e4= {3,3};
    eventsMap.put(4,e4);
    /* event 5 */
    int[] e5 = {-7,-7};
    eventsMap.put(5,e5);
    /* event 6 */
    int[] e6 = {5,8};
    eventsMap.put(6,e6);
    /* event 7 */
    int[] e7 = {-2,-1};
    eventsMap.put(7,e7);
    /* event 8 */
    int[] e8 = {-10,-2};
    eventsMap.put(8,e8);
    /* event 9 */
    int[] e9 = {10,10};
    eventsMap.put(9,e9);
    /* event 10 */
    int[] e10 = {0,1};
    eventsMap.put(10,e10);
    return eventsMap;
  }
  //generating seed data
  private static Map<Integer, double[]> eventsDet(){
    Map<Integer, double[]> eventDetails = new HashMap<Integer, double[]>();
    /* event 1 details */
    double[] d1 = {12.1,17.86,19.1,21.5};
    eventDetails.put(1,d1);
    /* event 2 details */
    double[] d2 = {22.6, 31.77, 20.97};
    eventDetails.put(2,d2);
    /* event 3 details */
    double[] d3 = {11.1, 11.56};
    eventDetails.put(3,d3);
    /* event 4 details */
    double[] d4 = {50.89, 55.9, 63.89};
    eventDetails.put(4,d4);
    /* event 5 details */
    double[] d5 = {67.9};
    eventDetails.put(5,d5);
    /* event 6 details */
    double[] d6 = {34.34, 31.2, 34.67, 39.89, 45.0, 46.6};
    eventDetails.put(6,d6);
    /* event 7 details */
    double[] d7 = {16.1, 16.25, 16.3};
    eventDetails.put(7,d7);
    /* event 8 details */
    double[] d8 = {20.99, 21.99, 22.99, 23.99};
    eventDetails.put(8,d8);
    /* event 9 details */
    double[] d9 = {45.6, 41.9, 40.5};
    eventDetails.put(9,d9);
    /* event 10 details */
    double[] d10 = {30.1, 30.5};
    eventDetails.put(10,d10);
    return eventDetails;
  }
}
