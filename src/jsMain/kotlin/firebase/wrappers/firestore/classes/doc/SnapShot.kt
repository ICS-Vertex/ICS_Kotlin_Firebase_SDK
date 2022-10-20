// Copyright 2022 ICS Vertex
package firebase.wrappers.firestore.classes.doc

data class SnapShot(
    val docChanges: List<DocChange>,
    val docs: Docs,
    val excludesMetadataChanges: Boolean,
    val fromCache: Boolean,
    val hasCachedResults: Boolean,
    val mutatedKeys: MutatedKeys,
    val oldDocs: OldDocs,
    val query: Query,
    val syncStateChanged: Boolean
) {
    data class DocChange(
        val doc: Doc,
        val type: Int
    ) {
        data class Doc(
            val `data`: Data,
            val documentState: Int,
            val documentType: Int,
            val key: Key,
            val readTime: ReadTime,
            val version: Version
        ) {
            data class Data(
                val value: Value
            ) {
                data class Value(
                    val mapValue: MapValue
                ) {
                    data class MapValue(
                        val fields: Fields
                    ) {
                        data class Fields(
                            val age: Age,
                            val name: Name
                        ) {
                            data class Age(
                                val integerValue: String
                            )

                            data class Name(
                                val stringValue: String
                            )
                        }
                    }
                }
            }

            data class Key(
                val path: Path
            ) {
                data class Path(
                    val len: Int,
                    val offset: Int,
                    val segments: List<String>
                )
            }

            data class ReadTime(
                val timestamp: Timestamp
            ) {
                data class Timestamp(
                    val nanoseconds: Int,
                    val seconds: Int
                )
            }

            data class Version(
                val timestamp: Timestamp
            ) {
                data class Timestamp(
                    val nanoseconds: Int,
                    val seconds: Int
                )
            }
        }
    }

    data class Docs(
        val keyedMap: KeyedMap,
        val sortedSet: SortedSet
    ) {
        data class KeyedMap(
            val root: Root
        ) {
            data class Root(
                val color: Boolean,
                val key: Key,
                val left: Left,
                val right: Right,
                val size: Int,
                val value: Value
            ) {
                data class Key(
                    val path: Path
                ) {
                    data class Path(
                        val len: Int,
                        val offset: Int,
                        val segments: List<String>
                    )
                }

                data class Left(
                    val size: Int
                )

                data class Right(
                    val size: Int
                )

                data class Value(
                    val `data`: Data,
                    val documentState: Int,
                    val documentType: Int,
                    val key: Key,
                    val readTime: ReadTime,
                    val version: Version
                ) {
                    data class Data(
                        val value: Value
                    ) {
                        data class Value(
                            val mapValue: MapValue
                        ) {
                            data class MapValue(
                                val fields: Fields
                            ) {
                                data class Fields(
                                    val age: Age,
                                    val name: Name
                                ) {
                                    data class Age(
                                        val integerValue: String
                                    )

                                    data class Name(
                                        val stringValue: String
                                    )
                                }
                            }
                        }
                    }

                    data class Key(
                        val path: Path
                    ) {
                        data class Path(
                            val len: Int,
                            val offset: Int,
                            val segments: List<String>
                        )
                    }

                    data class ReadTime(
                        val timestamp: Timestamp
                    ) {
                        data class Timestamp(
                            val nanoseconds: Int,
                            val seconds: Int
                        )
                    }

                    data class Version(
                        val timestamp: Timestamp
                    ) {
                        data class Timestamp(
                            val nanoseconds: Int,
                            val seconds: Int
                        )
                    }
                }
            }
        }

        data class SortedSet(
            val root: Root
        ) {
            data class Root(
                val color: Boolean,
                val key: Key,
                val left: Left,
                val right: Right,
                val size: Int,
                val value: Any?
            ) {
                data class Key(
                    val `data`: Data,
                    val documentState: Int,
                    val documentType: Int,
                    val key: Key,
                    val readTime: ReadTime,
                    val version: Version
                ) {
                    data class Data(
                        val value: Value
                    ) {
                        data class Value(
                            val mapValue: MapValue
                        ) {
                            data class MapValue(
                                val fields: Fields
                            ) {
                                data class Fields(
                                    val age: Age,
                                    val name: Name
                                ) {
                                    data class Age(
                                        val integerValue: String
                                    )

                                    data class Name(
                                        val stringValue: String
                                    )
                                }
                            }
                        }
                    }

                    data class Key(
                        val path: Path
                    ) {
                        data class Path(
                            val len: Int,
                            val offset: Int,
                            val segments: List<String>
                        )
                    }

                    data class ReadTime(
                        val timestamp: Timestamp
                    ) {
                        data class Timestamp(
                            val nanoseconds: Int,
                            val seconds: Int
                        )
                    }

                    data class Version(
                        val timestamp: Timestamp
                    ) {
                        data class Timestamp(
                            val nanoseconds: Int,
                            val seconds: Int
                        )
                    }
                }

                data class Left(
                    val size: Int
                )

                data class Right(
                    val size: Int
                )
            }
        }
    }

    data class MutatedKeys(
        val `data`: Data
    ) {
        data class Data(
            val root: Root
        ) {
            data class Root(
                val size: Int
            )
        }
    }

    data class OldDocs(
        val keyedMap: KeyedMap,
        val sortedSet: SortedSet
    ) {
        data class KeyedMap(
            val root: Root
        ) {
            data class Root(
                val size: Int
            )
        }

        data class SortedSet(
            val root: Root
        ) {
            data class Root(
                val size: Int
            )
        }
    }

    data class Query(
        val _t: List<T>,
        val collectionGroup: Any?,
        val endAt: Any?,
        val explicitOrderBy: List<Any>,
        val filters: List<Filter>,
        val limit: Int,
        val limitType: String,
        val path: Path,
        val startAt: Any?,
        val wt: Wt
    ) {
        data class T(
            val dir: String,
            val `field`: Field
        ) {
            data class Field(
                val len: Int,
                val offset: Int,
                val segments: List<String>
            )
        }

        data class Filter(
            val `field`: Field,
            val op: String,
            val value: Value
        ) {
            data class Field(
                val len: Int,
                val offset: Int,
                val segments: List<String>
            )

            data class Value(
                val stringValue: String
            )
        }

        data class Path(
            val len: Int,
            val offset: Int,
            val segments: List<String>
        )

        data class Wt(
            val collectionGroup: Any?,
            val endAt: Any?,
            val filters: List<Filter>,
            val ht: String,
            val limit: Int,
            val orderBy: List<OrderBy>,
            val path: Path,
            val startAt: Any?
        ) {
            data class Filter(
                val `field`: Field,
                val op: String,
                val value: Value
            ) {
                data class Field(
                    val len: Int,
                    val offset: Int,
                    val segments: List<String>
                )

                data class Value(
                    val stringValue: String
                )
            }

            data class OrderBy(
                val dir: String,
                val `field`: Field
            ) {
                data class Field(
                    val len: Int,
                    val offset: Int,
                    val segments: List<String>
                )
            }

            data class Path(
                val len: Int,
                val offset: Int,
                val segments: List<String>
            )
        }
    }
}