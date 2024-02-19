import {calculatePartHealth, calculateMachineHealth} from '../calculations';
import {
  AssemblyLinePart,
  MachineType,
  PaintingStationPart,
  QualityControlStationPart,
  WeldingRobotPart,
  partInfo,
} from '../../native-app/data/types';

describe('calculatePartHealth', () => {
  it('calculates WeldingRobot part health correctly', () => {
    const machineName: MachineType = MachineType.WeldingRobot;
    const part: partInfo = {name: WeldingRobotPart.ErrorRate, value: 0.5};
    const expectedHealth = 72.22222222222223;

    const result = calculatePartHealth(machineName, part);
    expect(result).toBe(expectedHealth);
  });

  it('calculates PaintingStation part health correctly', () => {
    const machineName: MachineType = MachineType.PaintingStation;
    const part: partInfo = {name: PaintingStationPart.ColorConsistency, value: 93.5};
    const expectedHealth = 85;

    const result = calculatePartHealth(machineName, part);
    expect(result).toBe(expectedHealth);
  });

  it('calculates AssemblyLine part health correctly', () => {
    const machineName: MachineType = MachineType.AssemblyLine;
    const part: partInfo = {name: AssemblyLinePart.AlignmentAccuracy, value: 0.9};
    const expectedHealth = 94.44444444444446;

    const result = calculatePartHealth(machineName, part);
    expect(result).toBe(expectedHealth);
  });

  it('calculates QualityControlStation part health correctly', () => {
    const machineName: MachineType = MachineType.QualityControlStation;
    const part: partInfo = {name: QualityControlStationPart.CriteriaSettings, value: 0.5};
    const expectedHealth = 75;

    const result = calculatePartHealth(machineName, part);
    expect(result).toBe(expectedHealth);
  });
});

describe('calculateMachineHealth', () => {
  it('calculates WeldingRobot machine health correctly', () => {
    const machineName: MachineType = MachineType.WeldingRobot;
    const parts = [
      {name: WeldingRobotPart.ErrorRate, value: 0.5},
      {name: WeldingRobotPart.VibrationLevel, value: 4.0},
      {name: WeldingRobotPart.ElectrodeWear, value: 0.8},
      {name: WeldingRobotPart.ShieldingPressure, value: 12.0},
      {name: WeldingRobotPart.WireFeedRate, value: 7.5},
      {name: WeldingRobotPart.ArcStability, value: 92.0},
      {name: WeldingRobotPart.SeamWidth, value: 1.5},
      {name: WeldingRobotPart.CoolingEfficiency, value: 85.0},
    ];
    const expectedHealth = 76.70138888888889;

    const result = calculateMachineHealth(machineName, parts);
    expect(result).toBe(expectedHealth);
  });

  it('calculates PaintingStation machine health correctly', () => {
    const machineName: MachineType = MachineType.PaintingStation;
    const parts = [
      {name: PaintingStationPart.FlowRate, value: 10.0},
      {name: PaintingStationPart.Pressure, value: 55.0},
      {name: PaintingStationPart.ColorConsistency, value: 92.0},
      {name: PaintingStationPart.NozzleCondition, value: 0.5},
    ];
    const expectedHealth = 80.00;

    const result = calculateMachineHealth(machineName, parts);
    expect(result).toBe(expectedHealth);
  });

  it('calculates AssemblyLine machine health correctly', () => {
    const machineName: MachineType = MachineType.AssemblyLine;
    const parts = [
      {name: AssemblyLinePart.AlignmentAccuracy, value: 0.5},
      {name: AssemblyLinePart.Speed, value: 8.0},
      {name: AssemblyLinePart.FittingTolerance, value: 0.03},
      {name: AssemblyLinePart.BeltSpeed, value: 1.3},
    ];
    const expectedHealth = 73.05555555555556;

    const result = calculateMachineHealth(machineName, parts);
    expect(result).toBe(expectedHealth);
  });

  it('calculates QualityControlStation machine health correctly', () => {
    const machineName: MachineType = MachineType.QualityControlStation;
    const parts = [
      {name: QualityControlStationPart.CameraCalibration, value: 0.5},
      {name: QualityControlStationPart.LightIntensity, value: 93.5},
      {name: QualityControlStationPart.SoftwareVersion, value: 1.8},
      {name: QualityControlStationPart.CriteriaSettings, value: 0.5},
    ];
    const expectedHealth = 81.25;

    const result = calculateMachineHealth(machineName, parts);
    expect(result).toBe(expectedHealth);
  });
});