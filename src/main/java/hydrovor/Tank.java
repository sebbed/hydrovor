package hydrovor;

/**
 * Tank provides water to Hydrovor and gets water from Pump
 */
public class Tank {

    private int maxVolume;

    private int volume;

    public Tank(int maxVolume, int volume)
    {
        if(maxVolume < 0 || volume < 0)
        {
            throw new IllegalArgumentException();
        }

        this.maxVolume = maxVolume;
        this.volume = volume;
    }

    /**
     * Simulates water out flow.
     *
     * @return 1 when there is any water (volume) and decrements volume; 0 otherwise
     */
    public int getWater()
    {
        if(volume > 0){
            volume--;
            return 1;
        }
        else
        {
            return 0;
        }

    }

    /**
     * Simulates filling up the tank.
     * <p/>
     * This method does not allow to exceed maxVolume.
     *
     * @param add amount of water attempted to be added
     *
     * @return amount of accepted water
     */
    public int addWater(int add)
    {
        if(add < 0)
        {
            throw new IllegalArgumentException();
        }

        int val = maxVolume - volume;

        if(val >= add)
        {
            volume += add;
            return add;
        }
        else
        {
            volume = maxVolume;
            return maxVolume - (add - val);
        }
    }
}
