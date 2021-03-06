package hydrovor;

/**
 * Hydrovor provides water to Sink and gets water from Tank
 */
public class Hydrovor {

    private Tank tank;

    private int volume;
    private boolean turnOn;

    public Hydrovor(Tank tank, int volume)
    {
        if(tank == null || volume < 0){
            throw new IllegalArgumentException();
        }
        this.tank = tank;
        this.volume = volume;
        this.turnOn = false;
    }

    public void on()
    {
        turnOn = true;
    }

    public void off()
    {
        turnOn = false;
    }

    /**
     * Simulates water out flow.
     *
     * @return 1 when there is any water (volume) and decrements volume; 0 otherwise
     */
    public int getWater()
    {
        if(volume>0)
        {
            volume--;
            return 1;
        }
        else
        {
            return 0;
        }
    }

    /**
     * When Hydrovor is on increments volume by value provided from Tank.
     */

    public void tick()
    {
        if(turnOn)
        {
            volume +=tank.getWater();
        }

    }
}
