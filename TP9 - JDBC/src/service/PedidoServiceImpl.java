package service;

import dao.ItemPedidoDAOImpl;
import dao.PedidoDAOImpl;
import dao.ProductoDAOImpl;
import model.ItemPedido;
import model.Pedido;
import model.Producto;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class PedidoServiceImpl {

    private PedidoDAOImpl pedidoDAO = new PedidoDAOImpl();
    private ItemPedidoDAOImpl itemDAO = new ItemPedidoDAOImpl();
    private ProductoDAOImpl productoDAO = new ProductoDAOImpl();

    public boolean crearPedido(Pedido pedido) {
        if (pedido.getItems() == null || pedido.getItems().isEmpty()) {
            System.out.println("El pedido debe contener al menos un producto.");
            return false;
        }

        double total = 0.0;
        for (ItemPedido item : pedido.getItems()) {
            if (item.getCantidad() <= 0) {
                System.out.println("Cantidad inválida en un ítem.");
                return false;
            }

            Producto prodBD = productoDAO.leer(item.getProducto().getId());
            if (prodBD == null || prodBD.getCantidad() < item.getCantidad()) {
                System.out.println("Producto inexistente o stock insuficiente.");
                return false;
            }

            item.setSubtotal(item.getCantidad() * prodBD.getPrecio());
            total += item.getSubtotal();
        }

        pedido.setFecha(LocalDate.now());
        pedido.setTotal(total);

        try (Connection conn = config.DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            int pedidoId = pedidoDAO.insertar(pedido, conn);

            for (ItemPedido item : pedido.getItems()) {
                itemDAO.insertar(item, pedidoId, conn);

                // Descontar stock
                Producto prod = item.getProducto();
                prod.setCantidad(prod.getCantidad() - item.getCantidad());
                productoDAO.actualizar(prod);
            }

            conn.commit();
            System.out.println("Pedido creado exitosamente.");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error: rollback ejecutado.");
            return false;
        }
    }

    public void mostrarDetallePedido(int pedidoId) {
        Pedido pedido = pedidoDAO.leer(pedidoId);
        if (pedido == null) {
            System.out.println("Pedido no encontrado.");
            return;
        }

        System.out.println("Detalle del pedido #" + pedido.getId());
        for (ItemPedido item : pedido.getItems()) {
            Producto p = item.getProducto();
            System.out.printf("- %s (%s): %d x %.2f = %.2f\n",
                    p.getNombre(), p.getCategoria().getNombre(),
                    item.getCantidad(), p.getPrecio(), item.getSubtotal());
        }
        System.out.printf("Total: %.2f\n", pedido.getTotal());
    }
}
