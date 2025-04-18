# Changelog

## [Unreleased]

## [1.1.5] - 2025-03-03
### Fixed
- Fixed parsing of `TimePosition` values to support more ISO 8601 compliant representations.
- Fixed `include` method of `Envelope` to correctly handle empty envelopes.

## [1.1.4] - 2025-01-19
### Changed
- Simplified internal matrix API and moved it to the `org.xmlobjects.gml.util.matrix` package.
- Updated xml-objects to 1.1.4.
- Updated Gradle to 8.12.

### Fixed
- The `include` method of `Envelope` is more robust against invalid input.

## [1.1.2] - 2024-12-01
### Changed
- Updated xml-objects to 1.1.2.

## [1.1.1] - 2024-07-15
### Added
- Added support for `week-date` in `TimePosition`.

## [1.1.0] - 2024-01-29
### Changed
- **Breaking:** Java 17 is now the minimum required version for using gml-objects.

### Fixed
- When computing envelopes, metadata of existing envelopes is now copied to the new envelopes.

## [1.0.4] - 2023-11-03
### Changed
- Updated xml-objects to 1.0.4.

## [1.0.3] - 2023-04-04
### Changed
- Updated xml-objects to 1.0.3.

## [1.0.2] - 2023-02-06
### Changed
- Updated xml-objects to 1.0.2.

## [1.0.1] - 2022-09-08
### Changed
- Updated xml-objects to 1.0.1.

## [1.0.0] - 2022-08-20
This is the initial release of gml-objects.

[Unreleased]: https://github.com/xmlobjects/gml-objects/compare/v1.1.5...HEAD
[1.1.5]: https://github.com/xmlobjects/gml-objects/releases/tag/v1.1.5
[1.1.4]: https://github.com/xmlobjects/gml-objects/releases/tag/v1.1.4
[1.1.2]: https://github.com/xmlobjects/gml-objects/releases/tag/v1.1.2
[1.1.1]: https://github.com/xmlobjects/gml-objects/releases/tag/v1.1.1
[1.1.0]: https://github.com/xmlobjects/gml-objects/releases/tag/v1.1.0
[1.0.4]: https://github.com/xmlobjects/gml-objects/releases/tag/v1.0.4
[1.0.3]: https://github.com/xmlobjects/gml-objects/releases/tag/v1.0.3
[1.0.2]: https://github.com/xmlobjects/gml-objects/releases/tag/v1.0.2
[1.0.1]: https://github.com/xmlobjects/gml-objects/releases/tag/v1.0.1
[1.0.0]: https://github.com/xmlobjects/gml-objects/releases/tag/v1.0.0