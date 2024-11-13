class Bank {
    protected double transactionCharges;

    public Bank() {
        this.transactionCharges = 50.0;
    }

    public double getTransactionCharges() {
        return transactionCharges;
    }

    public double calculateCharges() {
        return transactionCharges;
    }
}

class ICICI extends Bank {
    public ICICI() {
        super();
    }

    @Override
    public double calculateCharges() {
        double iciciCharges = super.getTransactionCharges();
        return iciciCharges - 10.0;
    }
}

class HDFC extends Bank {
    public HDFC() {
        super();
    }

    @Override
    public double calculateCharges() {
        double hdfcCharges = super.getTransactionCharges();
        return hdfcCharges - 20.0;
    }
}

 class Main {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Bank defaultBank = new Bank();
        ICICI iciciBank = new ICICI();
        HDFC hdfcBank = new HDFC();

        System.out.println("ICICI transaction charges: " + iciciBank.calculateCharges());
        System.out.println("HDFC transaction charges: " + hdfcBank.calculateCharges());
    }
}

