package GestionCresdits.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import GestionCresdits.services.Achat_ProduitServiceImp;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/AchatProduit")
public class AchatProduitController {

	private final Achat_ProduitServiceImp ser;
}
