package examPAW.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import examPAW.entity.ItemEntity;
import examPAW.service.ItemsService;

import java.util.List;

public class MainController {
    @Autowired
    private final ItemsService itemsService;

    public MainController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    //
    /**
     * o sa folosim /lista pentru afișarea datelor din tabela SQL
     */
    @GetMapping("/lista")
    public ResponseEntity<List<ItemEntity>> afisareDate() {
        List<ItemEntity> itemEntities = itemsService.getAllItems();
        return ResponseEntity.ok(itemEntities);
    }

    /**
     * o sa folosim /update pentru inserarea datelor preluate din API-ul extern
     */
    @PostMapping("/update")
    public String inserareDate() {
        return "Hello World";
    }

    /**
     * o sa folosim /item/{id} pentru furnizarea datelor corespunzătoare unei înregistrări din BD
     */
    @PostMapping("/item/{id}")
    public String furnizareDate() {
        return "Hello World";
    }
}
