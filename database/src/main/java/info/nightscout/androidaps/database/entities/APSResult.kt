package info.nightscout.androidaps.database.entities

import androidx.room.*
import info.nightscout.androidaps.database.TABLE_APS_RESULTS
import info.nightscout.androidaps.database.embedments.InterfaceIDs
import info.nightscout.androidaps.database.interfaces.DBEntry
import info.nightscout.androidaps.database.interfaces.DBEntryWithTime

@Entity(tableName = TABLE_APS_RESULTS,
        foreignKeys = [ForeignKey(
                entity = APSResult::class,
                parentColumns = ["id"],
                childColumns = ["referenceID"])],
        indices = [Index("referenceID"), Index("timestamp")])
data class APSResult(
        @PrimaryKey(autoGenerate = true)
        override var id: Long = 0,
        override var version: Int = 0,
        override var lastModified: Long = -1,
        override var valid: Boolean = true,
        override var referenceID: Long? = null,
        @Embedded
        override var interfaceIDs_backing: InterfaceIDs? = null,
        override var timestamp: Long,
        override var utcOffset: Long
) : DBEntry<APSResult>, DBEntryWithTime