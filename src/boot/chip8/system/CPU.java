package boot.chip8.system;

public class CPU {
    
    public static byte[] ram; // RAM Memory
    public static byte[] regs; // Registers - From V0 to VF - VF is a flag, should not be used
    
    public static byte st; // Sound Timer
    public static byte dt; // Delay Timer
    
    public static short i; // Stores Memory Addresses
    
    public static byte sp; // Stack Pointer - points to highest level to stack, in case, 0.
    public static byte pc; // Program Counter - points to currently executing address
    
    public CPU() {
        reset();
    }
    
    public synchronized void reset() {
        ram = new byte[4096];
        regs = new byte[16];
        
        st = 0;
        dt = 0;
        
        i = 0;
        
        sp = -1;
        pc = 0x200;
    }
    
    public void loadRom(byte[] buffer) {
        
    }
}
