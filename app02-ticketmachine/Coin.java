
/**
 * The Enumeration will represent a coin and will hold
 * different amounts of money
 *
 * @author Brandon Lim-Kee
 * @version 08/02/2021
 */
public enum Coin
{
    P010 (0.10f),

    P020 (0.20f),

    P1 (1f),

    P2 (2f);

    private final float value;
    
    /**
     * Assigns the value of a coin to the "value" variable
     */
    private Coin(float value)
    {
        this.value = value;
    }
    
    /**
     * Returns the value of the coin stored in the "value"
     * variable
     */
    public float getValue()
    {
        return value;
    }
}
