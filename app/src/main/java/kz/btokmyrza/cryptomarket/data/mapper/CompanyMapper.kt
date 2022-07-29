package kz.btokmyrza.cryptomarket.data.mapper

import kz.btokmyrza.cryptomarket.data.remote.dto.CompanyInfoDto
import kz.btokmyrza.cryptomarket.domain.model.CompanyInfo

fun CompanyInfoDto.toCompanyInfo(): CompanyInfo {
    return  CompanyInfo(
        symbol = symbol ?: "",
        description = description ?: "",
        name = name ?: "",
        country = country ?: "",
        industry = industry ?: ""
    )
}