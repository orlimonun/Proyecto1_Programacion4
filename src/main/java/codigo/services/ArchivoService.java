package codigo.services;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.*;
import java.io.IOException;

@Service
public class ArchivoService {

    private final Path carpetaCV = Paths.get("uploads/cv");

    public ArchivoService() {

        try {
            Files.createDirectories(carpetaCV);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo crear la carpeta de CV", e);
        }
    }

    public  void guardarCV(MultipartFile file, Long oferenteId){

        if (!file.getContentType().equals("application/pdf")) {
            throw new RuntimeException("Solo se permiten archivos PDF");
        }

        try {

            String nombreArchivo = "cv_" + oferenteId + ".pdf";

            Path rutaArchivo = carpetaCV.resolve(nombreArchivo);

            Files.copy(file.getInputStream(), rutaArchivo, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            throw new RuntimeException("Error al guardar el CV", e);
        }

    }
    public  Resource obtenerCV(Long oferenteId){

        try {

            Path rutaArchivo = carpetaCV.resolve("cv_" + oferenteId + ".pdf");

            Resource recurso = new UrlResource(rutaArchivo.toUri());

            if (recurso.exists() || recurso.isReadable()) {
                return recurso;
            } else {
                throw new RuntimeException("No se pudo leer el archivo");
            }

        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el CV", e);
        }

    }
}
