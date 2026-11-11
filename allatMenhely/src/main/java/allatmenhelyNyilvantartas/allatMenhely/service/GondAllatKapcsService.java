package allatmenhelyNyilvantartas.allatMenhely.service;


import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.GondAllatKapcsCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.display.GondAllatKapcsDisplayDto;

import java.util.List;

public interface GondAllatKapcsService {

    List<GondAllatKapcsDisplayDto> getAllGondAllatKapcs();
    GondAllatKapcsDisplayDto getGondAllatKapcsolatId(Long id);
    GondAllatKapcsDisplayDto createGondAllatKapcs(GondAllatKapcsCrudDto dto);
    GondAllatKapcsDisplayDto updateGondAllatKapcs(Long id,GondAllatKapcsCrudDto dto);
    void deleteGondAllatKapcs(Long id);
}
