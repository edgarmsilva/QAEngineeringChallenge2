import {calculatePartHealth, calculateMachineHealth} from '../calculations';
import {
  AssemblyLinePart,
  MachineType,
  PaintingStationPart,
  QualityControlStationPart,
  WeldingRobotPart,
} from '../../native-app/data/types';

describe('Machine Health Regression tests', () => {
  it('calculates WeldingRobot NormalRage', () => {
    const machineName: MachineType = MachineType.WeldingRobot;
    const parts = [
      {name: WeldingRobotPart.ErrorRate, value: 1.0},
      {name: WeldingRobotPart.VibrationLevel, value: 5.0},
      {name: WeldingRobotPart.ElectrodeWear, value: 1.0},
      {name: WeldingRobotPart.ShieldingPressure, value: 15.0},
      {name: WeldingRobotPart.WireFeedRate, value: 10.0},
      {name: WeldingRobotPart.ArcStability, value: 95.0},
      {name: WeldingRobotPart.SeamWidth, value: 2.0},
      {name: WeldingRobotPart.CoolingEfficiency, value: 90.0},
    ];
    const expectedHealth = 100;

    const result = calculateMachineHealth(machineName, parts);
    expect(result).toBe(expectedHealth);
  });

  it('calculates PaintingStation NormalRage', () => {
    const machineName: MachineType = MachineType.PaintingStation;
    const parts = [
      {name: PaintingStationPart.FlowRate, value: 30.0},
      {name: PaintingStationPart.Pressure, value: 60.0},
      {name: PaintingStationPart.ColorConsistency, value: 95.0},
      {name: PaintingStationPart.NozzleCondition, value: 1.0}
    ];
    const expectedHealth = 100;

    const result = calculateMachineHealth(machineName, parts);
    expect(result).toBe(expectedHealth);
  });

  it('calculates PaintingStation NormalRage', () => {
    const machineName: MachineType = MachineType.AssemblyLine;
    const parts = [
      {name: AssemblyLinePart.AlignmentAccuracy, value: 1.0},
      {name: AssemblyLinePart.Speed, value: 10.0},
      {name: AssemblyLinePart.FittingTolerance, value: 0.05},
      {name: AssemblyLinePart.BeltSpeed, value: 2.0}
    ];
    const expectedHealth = 100;

    const result = calculateMachineHealth(machineName, parts);
    expect(result).toBe(expectedHealth);
  });

  it('calculates QualityControlStation NormalRage', () => {
    const machineName: MachineType = MachineType.QualityControlStation;
    const parts = [
      {name: QualityControlStationPart.CameraCalibration, value: 1},
      {name: QualityControlStationPart.LightIntensity, value: 95.0},
      {name: QualityControlStationPart.SoftwareVersion, value: 2.0},
      {name: QualityControlStationPart.CriteriaSettings, value: 1.0}
    ];
    const expectedHealth = 75;

    const result = calculateMachineHealth(machineName, parts);
    expect(result).toBe(expectedHealth);
  });
  
});