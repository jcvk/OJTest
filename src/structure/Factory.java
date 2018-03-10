package structure;

/**
 * Created by Jvck on 2018/3/9.
 */
public class Factory {


    public interface Cpu {
        void calculate();
    }

    class IntelCpu implements Cpu{

        private int pins=0;

        public IntelCpu(int pins) {
            this.pins = pins;
        }

        @Override
        public void calculate() {
            System.out.println("Intel Cpu的脚针数量："+pins);
        }
    }

    class AmdlCpu implements Cpu{

        private int pins=0;

        public AmdlCpu(int pins) {
            this.pins = pins;
        }

        @Override
        public void calculate() {
            System.out.println("Amd Cpu的脚针数量："+pins);
        }
    }

    public interface MainBoard {
        void installCPU();
    }

    class IntelMainboard implements MainBoard{
        private int cpuHoles=0;

        @Override
        public void installCPU() {
            System.out.println("Intel主板的Cpu插槽孔数是："+cpuHoles);
        }

        public IntelMainboard(int cpuHoles) {
            this.cpuHoles = cpuHoles;
        }
    }

    class AmdMainboard implements MainBoard{
        private int cpuHoles=0;

        @Override
        public void installCPU() {
            System.out.println("Amd主板的Cpu插槽孔数是："+cpuHoles);
        }

        public AmdMainboard(int cpuHoles) {
            this.cpuHoles = cpuHoles;
        }
    }

    private interface AbstractFactory{
        Cpu createCpu();
        MainBoard createMainboard();
    }

    class IntelFactory implements AbstractFactory{

        @Override
        public Cpu createCpu() {
            return new IntelCpu(755);
        }

        @Override
        public MainBoard createMainboard() {
            return new IntelMainboard(755);
        }
    }

    class AmdFactory implements AbstractFactory{

        @Override
        public Cpu createCpu() {
            return new AmdlCpu(938);
        }

        @Override
        public MainBoard createMainboard() {
            return new AmdMainboard(938);
        }
    }

    class ComputerEngineer{

        private Cpu cpu=null;
        private MainBoard mainBoard=null;

        public void makeComputer(AbstractFactory af){
            prepareHardwares(af);
        }

        private void prepareHardwares(AbstractFactory af){
            this.cpu=af.createCpu();
            this.mainBoard=af.createMainboard();

            this.cpu.calculate();
            this.mainBoard.installCPU();
        }
    }

    public static void main(String[] args) {
        Factory factory=new Factory();

        ComputerEngineer cf=factory.new ComputerEngineer();
        AbstractFactory af=factory.new IntelFactory();
        cf.makeComputer(af);
    }
}
