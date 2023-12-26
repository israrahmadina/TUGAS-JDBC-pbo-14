import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Masukkan No Faktur: ");
            String noFaktur = scanner.nextLine();

            System.out.print("Masukkan Kode Barang: ");
            String kodeBarang  = scanner.nextLine();

            System.out.print("Masukkan Nama Pembeli: ");
            String namaPembeli = scanner.nextLine();

            System.out.print("Masukkan noHp : ");
            String noHp = scanner.nextLine();

            System.out.print("Masukkan Alamat Pelanggan: ");
            String alamatPelanggan = scanner.nextLine();

            System.out.print("Masukkan Nama Produk yang akan dibeli: ");
            String namaProduk = scanner.nextLine();

            System.out.print("Masukkan Harga Produk yang dibeli: ");
            double hargaProduk = scanner.nextDouble();

            System.out.print("Masukkan Jumlah Barang yang diBeli: ");
            int jumlahBeli = scanner.nextInt();

            pembelianProduk pembelian = new pembelianProduk(noFaktur,kodeBarang, namaPembeli, noHp,alamatPelanggan, namaProduk, hargaProduk, jumlahBeli);

            // Menampilkan informasi pembelian
            pembelian.tampilkanInfo();

            // Save purchase data to the database
            saveToDatabase(noFaktur, kodeBarang, namaPembeli, noHp, alamatPelanggan, namaProduk, hargaProduk, jumlahBeli);

            // Retrieve and display purchase data from the database
            retrieveFromDatabase();

        } catch (Exception e) {
            System.out.println("-----------------------------------------");
            System.out.println(" Mohon Maaf Telah Terjadi kesalahan: " + e.getMessage());
          
        } finally {
            scanner.close();
        }
    }

    // Function to save purchase data to the database
   private static void saveToDatabase(String noFaktur, String kodeBarang, String namaPembeli, String noHp, String alamatPelanggan,
            String namaProduk, double hargaProduk, int jumlahBeli) {
        try {
            // Establish database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket", "your_username", "your_password");

            // SQL query to insert data into the purchases table
            String sql = "INSERT INTO purchases (noFaktur, kodeBarang, namaPembeli, noHp, alamatPelanggan, namaProduk, hargaProduk, jumlahBeli) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Set parameter values
            statement.setString(1, noFaktur);
            statement.setString(2, kodeBarang);
            statement.setString(3, namaPembeli);
            statement.setString(4, noHp);
            statement.setString(5, alamatPelanggan);
            statement.setString(6, namaProduk);
            statement.setDouble(7, hargaProduk);
            statement.setInt(8, jumlahBeli);

            // Execute the query
            statement.executeUpdate();

            // Close resources
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Function to retrieve and display purchase data from the database
    private static void retrieveFromDatabase() {
        try {
            // Establish database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket", "israDina", "dina0908");

            // SQL query to select all data from the purchases table
            String sql = "SELECT * FROM purchases";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Display retrieved data
            while (resultSet.next()) {
                System.out.println("Retrieved Data from Database:");
                System.out.println("No Faktur: " + resultSet.getString("noFaktur"));
                // Display other fields as needed
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
