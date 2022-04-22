package tn.codynet.moduleventes.services;

import tn.codynet.moduleventes.entities.MvtStock;

import java.math.BigDecimal;
import java.util.List;

public interface IMvtStockService {
    BigDecimal realTimeStock(long idArticle);
    List<MvtStock> mvtStockArticle(long idArticle);
    MvtStock entreeStock(MvtStock mvtStock);
    MvtStock sortieStock(MvtStock mvtStock);
    MvtStock correctionStockPos(MvtStock mvtStock);
    MvtStock correctionStockNeg(MvtStock mvtStock);
}
