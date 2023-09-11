public class Bus{
   private int busNo;
   private boolean ac;
   private int capacity;

    Bus(int busNo,boolean ac,int capacity){
        this.busNo = busNo;
        this.ac = ac;
        this.capacity = capacity;

        System.out.println("BusNo: " + busNo + " Ac: "+ ac +" Capacity: " + capacity);
    }

    public int getCapacity(){
        return capacity;
    }

    public boolean isAc(){
        return ac;
    }

    public int getBusNo(){
        return busNo;
    }

    public void setAc(boolean val){
        ac = val;
    }

    public void setCapacaity(int cap){
        capacity = cap;
    }
}