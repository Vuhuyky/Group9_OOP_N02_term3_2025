public class RentalContractService extends GenericService<RentalContract, String> {

    @Override
    protected String getId(RentalContract obj) {
        return obj.getContractId(); // giả sử RentalContract có method getContractId()
    }

    // Các hàm đặc thù khác
}
