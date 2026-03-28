package codigo.services;

import codigo.models.Puesto;
import codigo.repositories.IPuestoRepository;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import org.springframework.stereotype.Service;

import com.itextpdf.layout.Document;
import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class ReporteService {

    private final IPuestoRepository puestoRepository;

    public ReporteService(IPuestoRepository puestoRepository) {
        this.puestoRepository = puestoRepository;
    }

   public byte[] generarReportePuestosPorMes(int mes, int anio){
        List<Puesto> puestos = puestoRepository
                .findPuestosByMesAndAnio(mes, anio);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        PdfWriter writer = new PdfWriter(baos);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        document.add(new Paragraph("Reporte de Puestos")
                .setBold()
                .setFontSize(18));

        document.add(new Paragraph("Mes: " + mes + " Año: " + anio));

        Table table = new Table(4);

        table.addHeaderCell("ID");
        table.addHeaderCell("Descripción");
        table.addHeaderCell("Salario");
        table.addHeaderCell("Empresa");

        for (Puesto puesto : puestos) {

            table.addCell(String.valueOf(puesto.getId()));
            table.addCell(puesto.getDescripcion());
            table.addCell(String.valueOf(puesto.getSalario()));
            table.addCell(puesto.getEmpresa().getNombre());
        }

        document.add(table);

        document.close();

        return baos.toByteArray();
    }

}
