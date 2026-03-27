package codigo.services;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ArchivoService {
    void guardarCV(MultipartFile file, Long oferenteId){}
    Resource obtenerCV(Long oferenteId){}
}
