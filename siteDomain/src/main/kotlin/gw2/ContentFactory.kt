package gw2

import repositories.ReadModelRepositories
import repositories.WriteModelRepositories

interface ContentFactory {
    val rmr: ReadModelRepositories
    val wmr: WriteModelRepositories
}
