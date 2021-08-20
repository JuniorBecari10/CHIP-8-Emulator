package boot.chip8.system;

public class System {
    
    public static byte[] ram;
    public static byte[] regs;
    
    public static byte st;
    public static byte dt;
    
    public static short i;
    
    
    
    public System() {
        ram = new byte[4096];
        regs = new byte[16];
        
        
    }
}
